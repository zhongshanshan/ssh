package lxz.dao;

import java.util.List;

import lxz.entity.Works;

public interface WorksDao {

	/**
	 * 添加作品：将从页面获得的works对象存到数据库
	 */
	public Works addWorksByUser_id(Works works, String user_id);

	/**
	 * 删除指定用户的指定作品_dao:通过user_id和works_id将works_state的值设置成2
	 */
	public boolean deleteUserWorksByUser_idAndWorks_id(String user_id, String works_id);

	/**
	 * 查找指定用户作品_dao：通过user_id查找List<works>
	 */
	public List<Works> findWorksListByUser_id(String user_id);

	/**
	 * 查找指定作品_dao：通过works_id查找works
	 */
	public Works findWorksByWorks_id(String work_id);

	/**
	 * 修改作品_dao：用户重新编辑不合格作品
	 */
	public Works updateWorksByUser_idAndWorks_id(Works works, String user_id, String works_id);

	/**
	 * 管理员审核未审核的作品_dao
	 */
	public List<Works> findUnauditedWorksList();

	/**
	 * 根据关键字查找worksList
	 */
	public List<Works> findKeyWorksList(String key);

}
