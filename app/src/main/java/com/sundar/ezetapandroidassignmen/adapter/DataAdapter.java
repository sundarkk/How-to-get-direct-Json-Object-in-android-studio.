package com.sundar.ezetapandroidassignmen.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundar.ezetapandroidassignmen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Activity activity;
    private JSONArray dataList;
    private LayoutInflater inflater;

    public DataAdapter(Activity activity, JSONArray dataList) {
        this.activity = activity;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataAdapter.ViewHolder(inflater.inflate(R.layout.data_adapter_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {

        JSONObject current = null;
        try {
            current = dataList.getJSONObject(position);
            Log.d("tag", "sk" + current);

            holder.txt_uitype.setText(current.getString("uitype"));
            holder.txt1.setText(current.getString("value"));
            holder.txt2.setText(current.getString("key"));
            holder.txt3.setText(current.getString("hint"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return dataList.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_uitype, txt1, txt2, txt3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_uitype = itemView.findViewById(R.id.txt_uitype);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            txt3 = itemView.findViewById(R.id.txt3);

        }
    }
}
