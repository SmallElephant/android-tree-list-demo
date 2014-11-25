package com.example.Helper;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class TreeViewItemClickListener implements OnItemClickListener {
	/** ����������� */
	private TreeViewAdapter treeViewAdapter;
	
	public TreeViewItemClickListener(TreeViewAdapter treeViewAdapter) {
		this.treeViewAdapter = treeViewAdapter;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		//�����item�����Ԫ��
		TreeNode treeNode = (TreeNode) treeViewAdapter.getItem(position);
		//���ж����Ԫ��
		ArrayList<TreeNode> topNodes = treeViewAdapter.getTopNodes();
		//Ԫ�ص�����Դ
		ArrayList<TreeNode> allNodes = treeViewAdapter.getAllNodes();
		
		//���û�������itemֱ�ӷ���
		if (!treeNode.isHasChildren()) {
			return;
		}
		
		if (treeNode.isExpanded()) {
			treeNode.setExpanded(false);
			//ɾ���ڵ��ڲ���Ӧ�ӽڵ����ݣ������ӽڵ���ӽڵ�...
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
			//������Դ����ȡ�ӽڵ�������ӽ������������һ���ӽڵ㣬Ϊ�˼��߼�
			int i = 1;//ע������ļ���������for������ܱ�֤������Ч
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