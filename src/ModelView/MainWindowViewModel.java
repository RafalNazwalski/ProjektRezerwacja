package ModelView;

import java.util.ArrayList;

public class MainWindowViewModel {

	ArrayList <RoomViewModel> listaPokoi = new ArrayList<>();
	
	private String login;

	public ArrayList<RoomViewModel> getListaPokoi() {
		return listaPokoi;
	}

	public void setListaPokoi(ArrayList<RoomViewModel> listaPokoi) {
		this.listaPokoi = listaPokoi;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}