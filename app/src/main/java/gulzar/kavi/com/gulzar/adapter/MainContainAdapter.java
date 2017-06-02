package gulzar.kavi.com.gulzar.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import gulzar.kavi.com.gulzar.OnLoadMoreListener;
import gulzar.kavi.com.gulzar.PoemViewActivity;
import gulzar.kavi.com.gulzar.R;
import gulzar.kavi.com.gulzar.utilities.GulzarCofig;

import static gulzar.kavi.com.gulzar.R.id.recyclerView;

/**
 * Created by Sushant.Patekar on 5/25/2017.
 */

public class MainContainAdapter extends RecyclerView.Adapter<MainContainAdapter.MainContianViewHolder> {
    List<GulzarCofig.Poem> poemList;
    Context mContext;

    private Activity activity;
    public MainContainAdapter(Activity activity, List<GulzarCofig.Poem> mPoem) {
        this.activity = activity;
        poemList= mPoem;


    }


    @Override
    public MainContianViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_maincontain_adapter, parent, false);

        return new MainContianViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainContianViewHolder holder, final int position) {
        GulzarCofig.Poem poem= poemList.get(position);
        if(position==0){
            holder.textIndicator.setVisibility(View.VISIBLE);
        }
        else{
            holder.textIndicator.setVisibility(View.GONE);
        }
        holder.poemtitle.setText(""+poem.getmSubtitle());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent= new Intent(activity, PoemViewActivity.class);
                    intent.putExtra(Intent.EXTRA_STREAM,""+(position));
                    activity.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return poemList.size();
    }


    public class MainContianViewHolder extends RecyclerView.ViewHolder{

        public TextView poemtitle , textIndicator;
        public RelativeLayout relativeLayout;
        public MainContianViewHolder(View itemView) {
            super(itemView);
            poemtitle = (TextView) itemView.findViewById(R.id.tvpoemTitle);
            textIndicator=(TextView)itemView.findViewById(R.id.tvIndicator);
        relativeLayout=(RelativeLayout)itemView.findViewById(R.id.rootLayout);
        }
    }
}
