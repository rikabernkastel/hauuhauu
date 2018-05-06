package com.hanyuuu.reglamentcreator;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.text.JTextComponent;

public class Reglament {
	/**
	 * Создание объекта типа FileWriter, используемого для записи в файл
	 */
	private FileWriter writer = null;
	/**
	 * Создание объекта типа FileWriter, используемого для чтения из файла
	 */
	private FileReader inputReader = null;
	/**
	 * Переменная для обозначения уровня регламента
	 */
	int importance;
	/**
	 * Переменная для обозначения названия регламента
	 */
	private String reglamentName;
	/**
	 * Переменная для обозначения пути к регламенту
	 */
	private String reglamentPath;
	/**
	 * Текстовый компонент с содержимым регламента
	 */
	private JTextComponent reglamentContent;

	/**
	 * Конструктор объекта типа регламент
	 * @param importance Уровень регламента
	 * @param reglamentName Название регламента
	 * @param reglamentPath Путь к регламенту
	 * @param reglamentContent Текстовый компонент с содержимым регламента
	 */
	public Reglament(int importance, String reglamentName, String reglamentPath, JTextComponent reglamentContent) {
		this.importance = importance;
		this.reglamentName = reglamentName;
		this.reglamentPath = reglamentPath;
		this.reglamentContent = reglamentContent;
	}
	/**
	 * Геттер для уровня регламента
	 */
	public int getImportance() {
		return importance;
	}
	/**
	 * Сеттер для уровня регламента
	 */
	public void setImportance(int importance) {
		this.importance = importance;
	}
	/**
	 * Геттер для названия регламента
	 */
	public String getReglamentName() {
		return reglamentName;
	}
	/**
	 * Сеттер для названия регламента
	 */
	public void setReglamentName(String reglamentName) {
		this.reglamentName = reglamentName;
	}
	/**
	 * Геттер для пути регламента
	 */
	public String getReglamentPath() {
		return reglamentPath;
	}
	/**
	 * Сеттер для пути регламента
	 */
	public void setReglamentPath(String reglamentPath) {
		this.reglamentPath = reglamentPath;
	}
	/**
	 * Геттер для текстового компонента с содержимым регламента
	 */
	public JTextComponent getReglamentContent() {
		return reglamentContent;
	}
	/**
	 * Сеттер для текстового компонента с содержимым регламента
	 */
	public void setReglamentContent(JTextComponent reglamentContent) {
		this.reglamentContent = reglamentContent;
	}
	/**
	 * Метод для сохранения регламента на жестком диске в определенной директории
	 */
	public void save() throws Exception {
		/**
		 * Открытие считывателя в файл
		 */
		writer = new FileWriter(reglamentPath + "/" + reglamentName + ".reglament");
		/**
		 * Запись в файл
		 */
		reglamentContent.write(writer);
		/**
		 * Закрытие считывателя в файл
		 */
		writer.close();
	}
	/**
	 * Метод для сохранения регламента на жестком диске в директории для обращения с ним программы
	 */
	public void savePermanently() throws Exception {
		/**
		 * Открытие считывателя в файл
		 */
		writer = new FileWriter("ReglamentForLevel " + importance + ".reglament");
		/**
		 * Запись в файл
		 */
		reglamentContent.write(writer);
		/**
		 * Закрытие считывателя в файл
		 */
		writer.close();
	}
	/**
	 * Метод для загрузки регламента в программу
	 */
	public void loadPermanently() throws Exception {
		/**
		 * Открытие считывателя из файла
		 */
		inputReader = new FileReader("ReglamentForLevel " + importance + ".reglament");
		/**
		 * Считывание из файла
		 */
		reglamentContent.read(inputReader, "ReglamentForLevel " + importance + ".reglament");
		/**
		 * Закрытие считывателя из файла
		 */
		inputReader.close();
	}
	/**
	 * Метод для загрузки структуры регламента в программу
	 */
	public void loaddefault() throws Exception {
		/**
		 * Открытие считывателя из файла
		 */
		inputReader = new FileReader("default.reglament");
		/**
		 * Считывание из файла
		 */
		reglamentContent.read(inputReader, "default.reglament");
		/**
		 * Закрытие считывателя из файла
		 */
		inputReader.close();
	}
}
