package io.purpleblock.allenmg.shopassistant.gui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class GeneralBeanTableColumnBuilder {
	public static <S, T> TableColumn<S, T> makeColumn(final String label, final String property) {
		TableColumn<S, T> tableColumn =  new TableColumn<S, T>(label);
		tableColumn.setCellValueFactory(new PropertyValueFactory<S, T>(property));
		return tableColumn;
	}
}
