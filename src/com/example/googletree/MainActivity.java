package com.example.googletree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;


public class MainActivity extends ExpandableListActivity  {

//	ExpandableListActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 创建一级条目
        List<Map<String, String>> provinces = new ArrayList<Map<String, String>>();
        //创建两个省份一级条目
        Map<String, String> firstProvince= new HashMap<String, String>();
        firstProvince.put("province", "河南");
        Map<String, String> secondProvince= new HashMap<String, String>();
        secondProvince.put("province", "北京");
        provinces.add(firstProvince);
        provinces.add(secondProvince);
        // 创建一级条目下的的二级地区条目
        List<Map<String, String>> childList1= new ArrayList<Map<String, String>>();
        //同样是在一级条目目录下创建两个对应的二级条目目录
        Map<String, String> child1= new HashMap<String, String>();
        child1.put("child", "郑州");
        Map<String, String> child2 = new HashMap<String, String>();
        child2.put("child", "开封");
        childList1.add(child1);
        childList1.add(child2);
        //同上
        List<Map<String, String>> childList2 = new ArrayList<Map<String, String>>();
        Map<String, String> child3 = new HashMap<String, String>();
        child3.put("child", "海淀");
        Map<String, String> child4 = new HashMap<String, String>();
        child4.put("child", "昌平");
        childList2.add(child3);
        childList2.add(child4);
        // 将二级条目放在一个集合里，供显示时使用
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
        childs.add(childList1);
        childs.add(childList2);
        /**
         * 使用SimpleExpandableListAdapter显示ExpandableListView
         * 参数1.上下文对象Context
         * 参数2.一级条目目录集合
         * 参数3.一级条目对应的布局文件
         * 参数4.fromto，就是map中的key，指定要显示的对象
         * 参数5.与参数4对应，指定要显示在groups中的id
         * 参数6.二级条目目录集合
         * 参数7.二级条目对应的布局文件
         * 参数8.fromto，就是map中的key，指定要显示的对象
         * 参数9.与参数8对应，指定要显示在childs中的id
         */
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, provinces, R.layout.province, new String[] { "province" },
                new int[] { R.id.list_provinceText }, childs, R.layout.child,
                new String[] { "child" }, new int[] { R.id.child_text });
     
        setListAdapter(adapter);
    }
    
    public void test(View view) {
		Intent intent=new Intent(this,TreeActivity.class);
		startActivity(intent);
	}
    
    /**
     * 设置哪个二级目录被默认选中
     */
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
            boolean shouldExpandGroup) {
            //do something
        return super.setSelectedChild(groupPosition, childPosition,
                shouldExpandGroup);
    }
    /**
     * 设置哪个一级目录被默认选中
     */
    @Override
    public void setSelectedGroup(int groupPosition) {
        //do something
        super.setSelectedGroup(groupPosition);
    }
    /**
     * 当二级条目被点击时响应
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
            //do something
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }



}
