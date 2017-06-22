package com.zs.recycler.recyclerviewanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //item 显示所需
    private String[] title = {"JAVA","C","C++","C#","PYTHON","PHP"
            ,".NET","JAVASCRIPT","RUBY","PERL","VB","OC","SWIFT"
    };
    private ArrayList<String> mTitle=new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        Collections.addAll(mTitle,title);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecyclerViewAdapter=new RecyclerViewAdapter(this, mTitle));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 更新列表position位置上的数据可以调用
     * notifyItemChanged(int position)
     *
     * 列表position位置添加一条数据时可以调用，伴有动画效果
     * notifyItemInserted(int position)
     *
     * 列表position位置移除一条数据时调用，伴有动画效果
     * notifyItemRemoved(int position)
     *
     * 列表fromPosition位置的数据移到toPosition位置时调用，伴有动画效果
     * notifyItemMoved(int fromPosition, int toPosition)
     *
     * 列表从positionStart位置到itemCount数量的列表项进行数据刷新
     * notifyItemRangeChanged(int positionStart, int itemCount)
     *
     * 列表从positionStart位置到itemCount数量的列表项批量添加数据时调用，伴有动画效果
     * notifyItemRangeInserted(int positionStart, int itemCount)
     *
     * 列表从positionStart位置到itemCount数量的列表项批量删除数据时调用，伴有动画效果
     * notifyItemRangeRemoved(int positionStart, int itemCount)
     *
     */

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.menu_add:
                    mTitle.add(0, "www.lijizhou.com");
                    mRecyclerViewAdapter.notifyItemInserted(0);
                    mRecyclerView.scrollToPosition(0);
                    break;

                case R.id.menu_del:
                    mTitle.remove(0);
                    mRecyclerViewAdapter.notifyItemRemoved(0);
                    break;

                case R.id.menu_move:
                    mRecyclerViewAdapter.notifyItemMoved(1,2);
                    break;

                case R.id.menu_addmore:
                    mTitle.add(0,"test");
                    mTitle.add(0,"test1");
                    mTitle.add(0,"test2");
                    mTitle.add(0,"test3");
                    mRecyclerViewAdapter.notifyItemRangeInserted(0,4);
                    mRecyclerView.scrollToPosition(0);
                    break;
            }
            return true;
        }
    };

}
