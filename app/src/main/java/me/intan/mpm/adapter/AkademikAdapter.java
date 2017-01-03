package me.intan.mpm.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import me.intan.mpm.R;
import me.intan.mpm.data.AkademikData;
import me.intan.mpm.main.AppController;

public class AkademikAdapter extends BaseAdapter {
    private final Activity activity;
    private LayoutInflater inflater;
    private final List<AkademikData> newsItems;
    private ImageLoader imageLoader;

    public AkademikAdapter(Activity activity, List<AkademikData> newsItems) {
        this.activity = activity;
        this.newsItems = newsItems;
    }

    @Override
    public int getCount() {
        return newsItems.size();
    }

    @Override
    public Object getItem(int location) {
        return newsItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row_akademik, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.news_gambar);
        TextView judul = (TextView) convertView.findViewById(R.id.news_judul);
        TextView timestamp = (TextView) convertView.findViewById(R.id.news_timestamp);
        TextView isi = (TextView) convertView.findViewById(R.id.news_isi);

        AkademikData news = newsItems.get(position);

        thumbNail.setImageUrl(news.getGambar(), imageLoader);
        judul.setText(news.getJudul());
        timestamp.setText(news.getDatetime());
        isi.setText(Html.fromHtml(news.getIsi()));

        return convertView;
    }

}