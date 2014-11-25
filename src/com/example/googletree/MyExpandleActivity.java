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
	 * ʵ�ֿ���չչ����ExpandableListView�����ַ�ʽ
	 * һ��ʹ��SimpleExpandableListAdpater������List���ϰ�װ��ExpandableListView ����
	 * ��չBaseExpandableListAdpter
	 * ����ʹ��simpleCursorTreeAdapter��Cursor�е����ݰ�װ��SimpleCuroTreeAdapter
	 */
	private String[] names = { "��Ѷ", "�ٶ�", "����Ͱ�" };

	private String[][] childnames = { { "����", "��С��","�罻"},
			{ "�����", "����","����" }, { "����", "½����","����" } };
	private ExpandableListView ep;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_expandle);

		// ���常�б���List���ݼ���
		List<Map<String, String>> group = new ArrayList<Map<String, String>>();
		// �������б���List���ݼ���
		List<List<Map<String, String>>> ss = new ArrayList<List<Map<String, String>>>();
		for (int i = 0; i < names.length; i++) {
			// �ṩ���б������
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("names", names[i]);
			group.add(maps);
			// �ṩ��ǰ���е���������
			List<Map<String, String>> child = new ArrayList<Map<String, String>>();
			for (int j = 0; j < names.length; j++) {
				Map<String, String> mapsj = new HashMap<String, String>();
				mapsj.put("map", childnames[i][j]);
				child.add(mapsj);
			}
			ss.add(child);
		}
		/**
		 * ��һ������ Ӧ�ó���ӿ� this �ڶ�������List<?extends Map<String,Object>>���� Ϊ�����ṩ����
		 * ���������� ������ʾ�������Դ�ļ� ���ĸ����� ��ֵ�б� ����Map�ֵ��key �����Ҫ��ʾ�ĸ������id ������ ���е���ʾ��Դ�ļ�
		 * ���߸����� ��ֵ�б������Map�ֵ��key �ڰ˸�Ҫ��ʾ���е����id
		 */
		SimpleExpandableListAdapter expand = new SimpleExpandableListAdapter(
				this, group, R.layout.images, new String[] { "names" },
				new int[] { R.id.txtName }, ss, R.layout.items,
				new String[] { "map" }, new int[] { R.id.items });
		ep = (ExpandableListView) findViewById(R.id.expanable_mylist);
		ep.setAdapter(expand);

	}

}
