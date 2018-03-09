package ru.rsreu.Zhilenko0804.dao;

import java.util.List;

import ru.rsreu.Zhilenko0804.data.Conference;

/**
 * DAO конференции
 * 
 * @author Maxim
 * 
 */
public interface ConferenceDAO {
	/**
	 * Получение конференций по дате
	 * 
	 * @param typeDateConference
	 * @return - список конференций
	 */
	public List<Conference> getConference(int typeDateConference);

	/**
	 * Получение конференций по дате и типу создателя
	 * 
	 * @param typeDateConference
	 * @param idModerator
	 * @param typeCreator
	 * @return - список конференций
	 */
	public List<Conference> getConferenceModerator(int typeDateConference,
			int idModerator, int typeCreator);

	/**
	 * Удаление конференции
	 * 
	 * @param idConference
	 * @param idClient
	 * @return
	 */
	public boolean deleteConference(int idConference, int idClient);

	public boolean addConference(int idClient, String nameConference,
			String date, String city);

}
