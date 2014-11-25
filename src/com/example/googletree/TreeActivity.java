package com.example.googletree;

import java.util.ArrayList;

import com.example.Helper.TreeNode;
import com.example.Helper.TreeViewAdapter;
import com.example.Helper.TreeViewItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Element;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TreeActivity extends Activity {

	/** ���еĶ���Ԫ�ؼ��� */
	private ArrayList<TreeNode> topNodes;
	/** ���е�Ԫ�ؼ��� */
	private ArrayList<TreeNode> allNodes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tree);
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		init();
		
		ListView treeview = (ListView) findViewById(R.id.tree_list);
		TreeViewAdapter treeViewAdapter = new TreeViewAdapter(topNodes, allNodes, inflater);
		TreeViewItemClickListener treeViewItemClickListener = new TreeViewItemClickListener(treeViewAdapter);
		treeview.setAdapter(treeViewAdapter);
		treeview.setOnItemClickListener(treeViewItemClickListener);
	}
	
	private void init() {
		topNodes = new ArrayList<TreeNode>();
		allNodes = new ArrayList<TreeNode>();
		
		//��ӽڵ�  -- �ڵ����ƣ��ڵ�level���ڵ�id�����ڵ�id���Ƿ����ӽڵ㣬�Ƿ�չ��
		
		//��������ڵ�
		TreeNode node1= new TreeNode("������", TreeNode.TOP_LEVEL, 0, TreeNode.NO_PARENT, true, false);
		
		//��ӵ�һ��ڵ�
		TreeNode node2= new TreeNode("������", TreeNode.TOP_LEVEL + 1, 1, node1.getId(), true, false);
		//��ӵڶ���ڵ�
		TreeNode node3= new TreeNode("������", TreeNode.TOP_LEVEL + 2, 2, node2.getId(), true, false);
		//��ӵ�����ڵ�
		TreeNode node7= new TreeNode("�Ի͹���", TreeNode.TOP_LEVEL + 3, 6, node3.getId(), false, false);
	
		
		//��ӵ�һ��ڵ�
		TreeNode node4= new TreeNode("����ʡ", TreeNode.TOP_LEVEL , 3, TreeNode.NO_PARENT, true, false);
		//��ӵڶ���ڵ�
		TreeNode node5= new TreeNode("֣����", TreeNode.TOP_LEVEL + 1, 4, node4.getId(), true, false);
		//��ӵ�����ڵ�
		TreeNode node6= new TreeNode("��ˮ��", TreeNode.TOP_LEVEL + 2, 5, node5.getId(), false, false);
	
		//��ӳ�ʼ��Ԫ��
		topNodes.add(node1);
		topNodes.add(node4);
		//��������Դ
		allNodes.add(node1);
		allNodes.add(node2);
		allNodes.add(node3);
		allNodes.add(node4);
		allNodes.add(node5);
		allNodes.add(node6);
		allNodes.add(node7);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.tree, menu);
//		return true;
//	}

}
