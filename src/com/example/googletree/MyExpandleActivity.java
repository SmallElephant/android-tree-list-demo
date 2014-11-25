package com.example.googletree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class MyExpandleActivity extends Activity {

	/**
	 * 实现可扩展展开列ExpandableListView的三种方式
	 * 一是使用SimpleExpandableListAdpater将两个List集合包装成ExpandableListView 二是
	 * 扩展BaseExpandableListAdpter
	 * 三是使用simpleCursorTreeAdapter将Cursor中的数据包装成SimpleCuroTreeAdapter
	 */
	private String[] names = { "腾讯", "百度", "阿里巴巴" };

	private String[][] childnames = { { "马化腾", "张小龙","社交"},
			{ "李彦宏", "马东敏","搜索" }, { "马云", "陆兆禧","电商" } };
	private ExpandableListView ep;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_expandle);

		// 定义父列表项List数据集合
		List<Map<String, String>> group = new ArrayList<Map<String, String>>();
		// 定义子列表项List数据集合
		List<List<Map<String, String>>> ss = new ArrayList<List<Map<String, String>>>();
		for (int i = 0; i < names.length; i++) {
			// 提供父列表的数据
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("names", names[i]);
			group.add(maps);
			// 提供当前父列的子列数据
			List<Map<String, String>> child = new ArrayList<Map<String, String>>();
			for (int j = 0; j < names.length; j++) {
				Map<String, String> mapsj = new HashMap<String, String>();
				mapsj.put("map", childnames[i][j]);
				child.add(mapsj);
			}
			ss.add(child);
		}
		/**
		 * 第一个参数 应用程序接口 this 第二个父列List<?extends Map<String,Object>>集合 为父列提供数据
		 * 第三个参数 父列显示的组件资源文件 第四个参数 键值列表 父列Map字典的key 第五个要显示的父列组件id 第六个 子列的显示资源文件
		 * 第七个参数 键值列表的子列Map字典的key 第八个要显示子列的组件id
		 */
		SimpleExpandableListAdapter expand = new SimpleExpandableListAdapter(
				this, group, R.layout.images, new String[] { "names" },
				new int[] { R.id.txtName }, ss, R.layout.items,
				new String[] { "map" }, new int[] { R.id.items });
		ep = (ExpandableListView) findViewById(R.id.expanable_mylist);
		ep.setAdapter(expand);

	}

}
