package com.example.bankingapp.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.bankingapp.Adapters.UserListAdapter;
import com.example.bankingapp.Database.DatabaseHelper;
import com.example.bankingapp.Model.Model;
import com.example.bankingapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Model> modelList_showlist = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    UserListAdapter adapter;
    SwipeRefreshLayout refresh;
    androidx.appcompat.widget.Toolbar toolbar;
    String phonenumber;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mRecyclerView = findViewById(R.id.recyclerviewf);
        refresh=findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                refresh.setRefreshing(false);
            }
        });

        showData();
    }

    private void showData() {
        modelList_showlist.clear();
        Cursor cursor = new DatabaseHelper(this).readalldata();
        while(cursor.moveToNext())
        {
            String balancefromdb = cursor.getString(2);
            Double balance = Double.parseDouble(balancefromdb);

            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setGroupingUsed(true);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            String price = nf.format(balance);

            Model model = new Model(cursor.getString(0), cursor.getString(1), price);
            modelList_showlist.add(model);
        }

        adapter = new UserListAdapter(MainActivity.this, modelList_showlist);
        mRecyclerView.setAdapter(adapter);

    }

    public void nextActivity(int position) {
        phonenumber = modelList_showlist.get(position).getPhoneno();
        Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
        intent.putExtra("phonenumber",phonenumber);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_history){
            startActivity(new Intent(MainActivity.this, TransactionHistoryActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}