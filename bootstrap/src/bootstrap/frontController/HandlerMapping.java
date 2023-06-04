package bootstrap.frontController;

import java.util.HashMap;

import bootstrap.controller.BoardViewController;
import bootstrap.controller.BoardDelete;
import bootstrap.controller.BoardDetailViewController;
import bootstrap.controller.BoardInsertController;
import bootstrap.controller.BoardInsertViewController;
import bootstrap.controller.BoardUpdateController;
import bootstrap.controller.BoardUpdateView;
import bootstrap.controller.Controller;
import bootstrap.controller.HomeController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
//		mappings.put("/home.do", new HomeController());
		mappings.put("/board.do", new BoardViewController());
		mappings.put("/boardInsertView.do", new BoardInsertViewController());
		mappings.put("/boardInsert.do", new BoardInsertController());
		mappings.put("/boardDetailView.do", new BoardDetailViewController());
		mappings.put("/boardDelete.do", new BoardDelete());
		mappings.put("/boardUpdateView.do", new BoardUpdateView());
		mappings.put("/boardUpdate.do", new BoardUpdateController());
	}
	// 넘겨주는 메서드     key = /memberList.do
	public Controller getController(String key) {
		// {key: value}
		// {/memberList.do}
		// mappings.get(key) = value
		
		return mappings.get(key);
	}
	
}
