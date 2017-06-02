package gulzar.kavi.com.gulzar.adapter;

/**
 * Created by Sushant.Patekar on 5/26/2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import gulzar.kavi.com.gulzar.GulzarApp;
import gulzar.kavi.com.gulzar.R;
import gulzar.kavi.com.gulzar.utilities.GulzarCofig;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    List<GulzarCofig.Poem> mpoemList;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, List<GulzarCofig.Poem> poemList) {
        this.context = context;
        mpoemList = poemList;
    }

    @Override
    public int getCount() {
        return mpoemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView tvTitle;
        TextView tvContent;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitlte);
        tvContent = (TextView) itemView.findViewById(R.id.tvpoemcontent);
        tvTitle.setText(mpoemList.get(position).getmSubtitle());
        if(mpoemList.get(position).getmContent_poem()!=null && !mpoemList.get(position).getmContent_poem().isEmpty())
        tvContent.setText(mpoemList.get(position).getmContent_poem());
        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}