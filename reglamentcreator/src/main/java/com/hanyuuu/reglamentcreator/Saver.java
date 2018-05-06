package com.hanyuuu.reglamentcreator;


import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Saver {
	/**
	 * Объявления экземпляра объекта типа JFileChooser
	 */
	private JFileChooser fileChooser;
	/**
	 * Объявление панели
	 */
	private JPanel panel;
	/**
	 * Метод возвращающий выбранную директорию
	 */
	public String getDirectory() {
		/**
		 * Инициализация экземпляра объекта типа JFileChooser
		 */
		fileChooser = new JFileChooser();
		/**
		 * Установка начальной директории
		 */
		fileChooser.setCurrentDirectory(new java.io.File("."));
		/**
		 * Установка названия для окна
		 */
		fileChooser.setDialogTitle("Выбрать директорию для сохранения...");
		/**
		 * Установка типа выбираемых объектов на директории
		 */
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		/**
		 * Установка выбора любых файлов
		 */
		fileChooser.setAcceptAllFileFilterUsed(false);
		/**
		 * Если нажата кнопка выбора, то будет возвращена ссылку на выбранную директорию
		 */
		if (fileChooser.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().getAbsolutePath();
			/**
			 * Если не выбрано ничего, то будет возвращена пустая строка
			 */
		} else {
			return "";
		}
	}
}

