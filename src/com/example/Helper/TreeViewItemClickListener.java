package com.example.Helper;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class TreeViewItemClickListener implements OnItemClickListener {
	/** 定义的适配器 */
	private TreeViewAdapter treeViewAdapter;
	
	public TreeViewItemClickListener(TreeViewAdapter treeViewAdapter) {
		this.treeViewAdapter = treeViewAdapter;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		//点击的item代表的元素
		TreeNode treeNode = (TreeNode) treeViewAdapter.getItem(position);
		//树中顶层的元素
		ArrayList<TreeNode> topNodes = treeViewAdapter.getTopNodes();
		//元素的数据源
		ArrayList<TreeNode> allNodes = treeViewAdapter.getAllNodes();
		
		//点击没有子项的item直接返回
		if (!treeNode.isHasChildren()) {
			return;
		}
		
		if (treeNode.isExpanded()) {
			treeNode.setExpanded(false);
			//删除节点内部对应子节点数据，包括子节点的子节点...
			ArrayList<TreeNode> elementsToDel = new ArrayList<TreeNode>();
			for (int i = position + 1; i < topNodes.size(); i++) {
				if (treeNode.getLevel() >= topNodes.get(i).getLevel())
					break;
				elementsToDel.add(topNodes.get(i));
			}
			topNodes.removeAll(elementsToDel);
			treeViewAdapter.notifyDataSetChanged();
		} else {
			treeNode.setExpanded(true);
			//从数据源中提取子节点数据添加进树，添加了下一级子节点，为了简化逻辑
			int i = 1;//注意这里的计数器放在for外面才能保证计数有效
			for (TreeNode e : allNodes) {
				if (e.getParendId() == treeNode.getId()) {
					e.setExpanded(false);
					topNodes.add(position + i, e);
					i ++;
				}
			}
			treeViewAdapter.notifyDataSetChanged();
		}
	}

}