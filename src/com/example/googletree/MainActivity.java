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
        
        // ����һ����Ŀ
        List<Map<String, String>> provinces = new ArrayList<Map<String, String>>();
        //��������ʡ��һ����Ŀ
        Map<String, String> firstProvince= new HashMap<String, String>();
        firstProvince.put("province", "����");
        Map<String, String> secondProvince= new HashMap<String, String>();
        secondProvince.put("province", "����");
        provinces.add(firstProvince);
        provinces.add(secondProvince);
        // ����һ����Ŀ�µĵĶ���������Ŀ
        List<Map<String, String>> childList1= new ArrayList<Map<String, String>>();
        //ͬ������һ����ĿĿ¼�´���������Ӧ�Ķ�����ĿĿ¼
        Map<String, String> child1= new HashMap<String, String>();
        child1.put("child", "֣��");
        Map<String, String> child2 = new HashMap<String, String>();
        child2.put("child", "����");
        childList1.add(child1);
        childList1.add(child2);
        //ͬ��
        List<Map<String, String>> childList2 = new ArrayList<Map<String, String>>();
        Map<String, String> child3 = new HashMap<String, String>();
        child3.put("child", "����");
        Map<String, String> child4 = new HashMap<String, String>();
        child4.put("child", "��ƽ");
        childList2.add(child3);
        childList2.add(child4);
        // ��������Ŀ����һ�����������ʾʱʹ��
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
        childs.add(childList1);
        childs.add(childList2);
        /**
         * ʹ��SimpleExpandableListAdapter��ʾExpandableListView
         * ����1.�����Ķ���Context
         * ����2.һ����ĿĿ¼����
         * ����3.һ����Ŀ��Ӧ�Ĳ����ļ�
         * ����4.fromto������map�е�key��ָ��Ҫ��ʾ�Ķ���
         * ����5.�����4��Ӧ��ָ��Ҫ��ʾ��groups�е�id
         * ����6.������ĿĿ¼����
         * ����7.������Ŀ��Ӧ�Ĳ����ļ�
         * ����8.fromto������map�е�key��ָ��Ҫ��ʾ�Ķ���
         * ����9.�����8��Ӧ��ָ��Ҫ��ʾ��childs�е�id
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
     * �����ĸ�����Ŀ¼��Ĭ��ѡ��
     */
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
            boolean shouldExpandGroup) {
            //do something
        return super.setSelectedChild(groupPosition, childPosition,
                shouldExpandGroup);
    }
    /**
     * �����ĸ�һ��Ŀ¼��Ĭ��ѡ��
     */
    @Override
    public void setSelectedGroup(int groupPosition) {
        //do something
        super.setSelectedGroup(groupPosition);
    }
    /**
     * ��������Ŀ�����ʱ��Ӧ
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
            //do something
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }



}
