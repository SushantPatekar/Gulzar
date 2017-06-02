package gulzar.kavi.com.gulzar.youtube;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.HashMap;
import java.util.Map;

import gulzar.kavi.com.gulzar.R;

/***********************************************************************************
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 Scott Cooper
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 ***********************************************************************************/

public class VideoListAdapter extends BaseAdapter implements YouTubeThumbnailView.OnInitializedListener {

    private Activity mActivity;
    private Map<View, YouTubeThumbnailLoader> mLoaders;

    public VideoListAdapter( Activity Activity) {
        mActivity = Activity;
        mLoaders = new HashMap<>();
    }

    @Override
    public int getCount() {
        return YouTubeContent.ITEMS.size();
    }

    @Override
    public Object getItem(int position) {
        return YouTubeContent.ITEMS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VideoHolder holder;

        //The item at the current position
        final YouTubeContent.YouTubeVideo item = YouTubeContent.ITEMS.get(position);

        if (convertView == null) {
            //Create the row
            final LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout, parent, false);

            //Create the video holder
            holder = new VideoHolder();

            //Set the title
            holder.baserow = (RelativeLayout)convertView.findViewById(R.id.baserow);
            holder.title = (TextView) convertView.findViewById(R.id.textView_title);
            holder.title.setText(item.title);

            //Initialise the thumbnail
            holder.thumb = (YouTubeThumbnailView) convertView.findViewById(R.id.imageView_thumbnail);
            holder.thumb.setTag(item.id);
            holder.thumb.initialize(mActivity.getString(R.string.DEVELOPER_KEY), this);

          holder.baserow.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (YouTubeIntents.canResolvePlayVideoIntent(mActivity)) {
                      //Opens the video in the YouTube app
                      mActivity.startActivity(YouTubeIntents.createPlayVideoIntent(mActivity, item.id));
                  }
              }
          });
            convertView.setTag(holder);
        } else {
            //Create it again
            holder = (VideoHolder) convertView.getTag();
            final YouTubeThumbnailLoader loader = mLoaders.get(holder.thumb);

            if (item != null) {
                //Set the title
                holder.title.setText(item.title);

                //Setting the video id can take a while to actually change the image
                //in the meantime the old image is shown.
                //Removing the image will cause the background color to show instead, not ideal
                //but preferable to flickering images.
                holder.thumb.setImageBitmap(null);
                holder.baserow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (YouTubeIntents.canResolvePlayVideoIntent(mActivity)) {
                            //Opens the video in the YouTube app
                            mActivity.startActivity(YouTubeIntents.createPlayVideoIntent(mActivity, item.id));
                        }
                    }
                });
                if (loader == null) {
                    //Loader is currently initialising
                    holder.thumb.setTag(item.id);
                } else {
                    //The loader is already initialised
                    //Note that it's possible to get a DeadObjectException here
                    try {
                        loader.setVideo(item.id);
                    } catch (IllegalStateException exception) {
                        //If the Loader has been released then remove it from the map and re-init
                        mLoaders.remove(holder.thumb);
                        holder.thumb.initialize(mActivity.getString(R.string.DEVELOPER_KEY), this);

                    }
                }

            }
        }
        return convertView;
    }


    @Override
    public void onInitializationSuccess(YouTubeThumbnailView view, YouTubeThumbnailLoader loader) {
        mLoaders.put(view, loader);
        loader.setVideo((String) view.getTag());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView thumbnailView, YouTubeInitializationResult errorReason) {
        final String errorMessage = errorReason.toString();
        Toast.makeText(mActivity, errorMessage, Toast.LENGTH_LONG).show();
    }


    static class VideoHolder {
        RelativeLayout baserow;
        YouTubeThumbnailView thumb;
        TextView title;
    }
}
