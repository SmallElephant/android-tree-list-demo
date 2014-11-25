package com.example.Helper;


import java.util.ArrayList;

import com.example.googletree.R;

import android.renderscript.Element;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TreeViewAdapter extends BaseAdapter {
	/** ���е����ݼ��� */
	private ArrayList<TreeNode> allNodes;
	/** ����Ԫ�ؽ��*/
	private ArrayList<TreeNode> topNodes;
	/** LayoutInflater */
	private LayoutInflater inflater;
	/** item�������������� */
	private int indentionBase;
	
	public TreeViewAdapter(ArrayList<TreeNode> topNodes, ArrayList<TreeNode> allNodes, LayoutInflater inflater) {
		this.topNodes = topNodes;
		this.allNodes = allNodes;
		this.inflater = inflater;
		indentionBase =20;
	}
	public ArrayList<TreeNode> getTopNodes() {
		return topNodes;
	}
	
	public ArrayList<TreeNode> getAllNodes() {
		return allNodes;
	}
	
	@Override
	public int getCount() {
		return topNodes.size();
	}

	@Override
	public Object getItem(int position) {
		return topNodes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.tree_item, null);
			holder.homeImg = (ImageView) convertView.findViewById(R.id.homeImg);
			holder.treeText = (TextView) convertView.findViewById(R.id.treeText);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		TreeNode element = topNodes.get(position);
		int level =element.getLevel();
		holder.homeImg.setPadding(
				indentionBase * (level + 1), 
				holder.homeImg.getPaddingTop(), 
				holder.homeImg.getPaddingRight(), 
				holder.homeImg.getPaddingBottom());
		holder.treeText.setText(element.getContentText());
		if (element.isHasChildren() && !element.isExpanded()) {
			holder.homeImg.setImageResource(R.drawable.open);
			//����Ҫ��������һ��icon�ɼ�����ΪconvertView�п�����������"�����˲��ɼ�"��view����ͬ��
			holder.homeImg.setVisibility(View.VISIBLE);
		} else if (element.isHasChildren() && element.isExpanded()) {
			holder.homeImg.setImageResource(R.drawable.open);
			holder.homeImg.setVisibility(View.VISIBLE);
		} else if (!element.isHasChildren()) {
			holder.homeImg.setImageResource(R.drawable.open);
			holder.homeImg.setVisibility(View.VISIBLE);
		}
		return convertView;
	}
	
	static class ViewHolder{
		ImageView homeImg;
		TextView treeText;
	}
}
