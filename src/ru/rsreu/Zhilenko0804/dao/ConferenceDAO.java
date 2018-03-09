package ru.rsreu.Zhilenko0804.dao;

import java.util.List;

import ru.rsreu.Zhilenko0804.data.Conference;

/**
 * DAO �����������
 * 
 * @author Maxim
 * 
 */
public interface ConferenceDAO {
	/**
	 * ��������� ����������� �� ����
	 * 
	 * @param typeDateConference
	 * @return - ������ �����������
	 */
	public List<Conference> getConference(int typeDateConference);

	/**
	 * ��������� ����������� �� ���� � ���� ���������
	 * 
	 * @param typeDateConference
	 * @param idModerator
	 * @param typeCreator
	 * @return - ������ �����������
	 */
	public List<Conference> getConferenceModerator(int typeDateConference,
			int idModerator, int typeCreator);

	/**
	 * �������� �����������
	 * 
	 * @param idConference
	 * @param idClient
	 * @return
	 */
	public boolean deleteConference(int idConference, int idClient);

	public boolean addConference(int idClient, String nameConference,
			String date, String city);

}
