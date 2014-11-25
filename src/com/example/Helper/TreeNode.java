package com.example.Helper;

public class TreeNode {
	/** �������� */
	private String contentText;
	/** ��tree�еĲ㼶 */
	private int level;
	/** Ԫ�ص�id */
	private int id;
	/** ��Ԫ�ص�id */
	private int parendId;
	/** �Ƿ�����Ԫ�� */
	private boolean hasChildren;
	/** item�Ƿ�չ�� */
	private boolean isExpanded;
	
	/** ��ʾ�ýڵ�û�и�Ԫ�أ�Ҳ����levelΪ0�Ľڵ� */
	public static final int NO_PARENT = -1;
	/** ��ʾ��Ԫ��λ�����Ĳ㼶 */
	public static final int TOP_LEVEL = 0;
	
	public TreeNode(String contentText, int level, int id, int parendId,
			boolean hasChildren, boolean isExpanded) {
		super();
		this.contentText = contentText;
		this.level = level;
		this.id = id;
		this.parendId = parendId;
		this.hasChildren = hasChildren;
		this.isExpanded = isExpanded;
	}

	public boolean isExpanded() {
		return isExpanded;
	}

	public void setExpanded(boolean isExpanded) {
		this.isExpanded = isExpanded;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParendId() {
		return parendId;
	}

	public void setParendId(int parendId) {
		this.parendId = parendId;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
}