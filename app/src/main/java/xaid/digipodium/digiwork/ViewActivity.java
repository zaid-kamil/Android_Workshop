package xaid.digipodium.digiwork;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    List<String> messages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        RecyclerView messageList = findViewById(R.id.messageList);
        messageList.setLayoutManager(new LinearLayoutManager(this));

        //later
        MessageAdapter adapter = new MessageAdapter();
        messageList.setAdapter(adapter);

    }


    /*Adapter class*/
    class MessageAdapter extends RecyclerView.Adapter<Holder> {



        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(ViewActivity.this).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int i) {
            String msg = messages.get(i);
            holder.text.setText(msg);
        }

        @Override
        public int getItemCount() {
            return messages.size();
        }
    }


    private class Holder extends RecyclerView.ViewHolder {
        TextView text;

        public Holder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(android.R.id.text1);
        }
    }
}
