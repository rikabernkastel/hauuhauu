package com.hanyuuu.reglamentcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InspectReglamentWindow extends ReglamentWindow {
	/**
	 * Объявление элементов:
	 * 
	 * mainPanel – Основная панель
	 * mainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * scrollPane – Панель с ползунком для текстового поля
	 * mainTextPanel – Основное текстовое поле для ввода
	 * saveButton – Кнопка для сохранения регламента на жестком диске
	 * back – Кнопка для перехода в основное меню программы
	 * window – Класс основного окна
	 * reglament – Объект типа Reglament, определяющий регламент
	 * a – Объект типа Saver, используемый для выбора директории для сохранения
	 */
	private JPanel mainPanel;
	private JScrollPane scrollPane;
	private JTextArea mainTextPanel;
	private JFrame mainFrame;
	private JButton saveButton;
	private JButton back;
	private int reglamentLevel;
	private SelectWindow window;
	private Reglament reglament;
	private Saver a;
	/**
	 * Создание конструктора для класса окна просмотра регламента
	 * @param reglamentLevel Уровень регламента, требуемый для создания отдельного экземпляра этого окна
	 */
	public InspectReglamentWindow(int reglamentLevel) {
		this.reglamentLevel = reglamentLevel;
	}
	/**
	 * Геттер уровня создаваемого регламента
	 */
	public int getLevel() {
		return reglamentLevel;
	}
	/**
	 * Сеттер уровня создаваемого регламента
	 */
	public void setLevel(int reglamentLevel) {
		this.reglamentLevel = reglamentLevel;
	}
	/**
	 * Метод, инициализирующий граф. интерфейс
	 */
	private void spawn(final int reglamentLevel) {
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основной текстовой панели с параметром false, недопускающим редактирование
		 */
		mainTextPanel = CreateMainTextPanel(false);
		/**
		 * Создание кнопки сохранения регламента на диск, задание названия, задание названия кнопки и ее размеров
		 */
		saveButton = CreateButton("Сохранить на диск", 20, 370, 150, 30);
		/**
		 * Создание кнопки возвращения к основному меню, задание названия, задание названия кнопки и ее размеров
		 */
		back = CreateButton("Назад", 180, 370, 120, 30);
		/**
		 * Создание основного фрейма, задание названия, задания уровня регламента, прикрепление к панели
		 */
		mainFrame = CreateMainFrame("Просмотр регламента для уровня ", reglamentLevel, mainPanel);
		/**
		 * Создание панели с ползунком, привязка к текстовой панели
		 */
		scrollPane = createScrollPane(mainTextPanel);
		
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(mainFrame, scrollPane);
		addComponentToFrame(mainFrame, saveButton);
		addComponentToFrame(mainFrame, back);
		/**
		 * Создания экземплеяра объекта типа Reglament, установка уровня,
		 * установка пустого названия, содержания и привязка к текстовой панели
		 */
		reglament = new Reglament(reglamentLevel, "", "", mainTextPanel);

		/**
		 * Создания экземпляра основного окна
		 */
		window = new SelectWindow();
		/**
		 * Создание слушателей для кнопок
		 */
		/**
		 * Создания слушателя для кнопки сохранения
		 */
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Создание экземпляра объекта Saver, вызывающий интерфейс выбора директории на диске
					 */
					a = new Saver();
					/**
					 * Запись пути к выбранной директории в строку 
					 */
					String p = a.getDirectory();
					/**
					 * Если директория выбрана, производится сохранение
					 */
					if (p != "") {
						/**
						 * Установка пути для сохранения регламенту
						 */
						reglament.setReglamentPath(p);
						/**
						 * Установка названия регламента
						 */
						reglament.setReglamentName("ReglamentForLevel " + reglamentLevel);
						/**
						 * Установка содержимого регламента
						 */
						reglament.setReglamentContent(mainTextPanel);
						/**
						 * Вызов метода, сохраняющего регламент на диск
						 */
						reglament.save();
						/**
						 * Если директория не была выбрана, вывести сообщение о том,
						 * что сохранение не будет произведено
						 */
					} else {
						JOptionPane.showMessageDialog(mainFrame,
								"Директория не выбрана. Сохранение произведено не будет.", "Отмена",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * Создание слушателя для кнопки возврата
		 */
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Вызов метода инициализирующего граф. интерфейс основного окна
				 */
				window.init();
			}
		});
		/**
		 * Загрузка регламента при открытии окна
		 */
		try {
			/**
			 * Установка текстовой панели для записи в нее содержимого регламента
			 */
			reglament.setReglamentContent(mainTextPanel);
			/**
			 * Метод, производящий загрузку регламента
			 */
			reglament.loadPermanently();
			/**
			 * Вывод сообщения об ошибки отсутствия регламента на диске
			 */
		} catch (FileNotFoundException e1) {
			System.out.println("Невозможно загрузить регламент. Регламент ещё не был назначен.");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(mainFrame);
	}
	/**
	 * Публичный метод для вызова граф. интерфейса этого окна из других классов
	 */
	public void init() {
		spawn(reglamentLevel);
	}
}

