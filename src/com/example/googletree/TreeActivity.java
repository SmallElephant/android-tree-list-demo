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

	/** 树中的顶层元素集合 */
	private ArrayList<TreeNode> topNodes;
	/** 所有的元素集合 */
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
		
		//添加节点  -- 节点名称，节点level，节点id，父节点id，是否有子节点，是否展开
		
		//添加最外层节点
		TreeNode node1= new TreeNode("北京市", TreeNode.TOP_LEVEL, 0, TreeNode.NO_PARENT, true, false);
		
		//添加第一层节点
		TreeNode node2= new TreeNode("海淀区", TreeNode.TOP_LEVEL + 1, 1, node1.getId(), true, false);
		//添加第二层节点
		TreeNode node3= new TreeNode("西二旗", TreeNode.TOP_LEVEL + 2, 2, node2.getId(), true, false);
		//添加第三层节点
		TreeNode node7= new TreeNode("辉煌国际", TreeNode.TOP_LEVEL + 3, 6, node3.getId(), false, false);
	
		
		//添加第一层节点
		TreeNode node4= new TreeNode("河南省", TreeNode.TOP_LEVEL , 3, TreeNode.NO_PARENT, true, false);
		//添加第二层节点
		TreeNode node5= new TreeNode("郑州市", TreeNode.TOP_LEVEL + 1, 4, node4.getId(), true, false);
		//添加第三层节点
		TreeNode node6= new TreeNode("金水区", TreeNode.TOP_LEVEL + 2, 5, node5.getId(), false, false);
	
		//添加初始树元素
		topNodes.add(node1);
		topNodes.add(node4);
		//创建数据源
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
