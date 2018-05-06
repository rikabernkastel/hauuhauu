package com.hanyuuu.reglamentcreator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstallReglamentWindow extends ReglamentWindow {
	/**
	 * Объявление элементов:
	 * 
	 * mainTextPanel – Основное текстовое поле для ввода
	 * mainPanel – Основная панель
	 * mainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * temp1 – Строка для временного хранения содержимого регламента
	 * del – Строка для временного хранения содержимого регламента, подлежащего удалению
	 * temp2 – Переменная для временного хранения размеров содержимого регламента
	 * scrollPane – Панель с ползунком для текстового поля
	 * abcde – Шрифт для содержимого регламента
	 * bar – Панель меню
	 * edit, font – Меню в панель
	 * item1, item2, item3, item4, item5 – Элементы меню edit
	 * fstyle1, fstyle2, fstyle3, fstyle4 – Элементы меню font
	 * reglamentLevel – Переменная для хранения уровня регламента
	 * reglament – Объект типа Reglament, определяющий регламент
	 * window – Экземпляр окна администрирования
	 * saveButton – Кнопка для сохранения регламента на жестком диске
	 * back – Кнопка для сохранения регламента на жестком диске
	 * loadDefault – Кнопка для сохранения регламента на жестком диске
	 * a – Объект типа Saver, используемый для выбора директории для сохранения
	 */
	private JTextArea mainTextPanel;
	private JPanel mainPanel;
	private JFrame mainFrame;

	private String temp1 = "";
	private String del;
	private int temp2;
	private JScrollPane scrollPane;

	private Font abcde = new Font("Monotype Corsiva", Font.PLAIN, 15);
	
	private JMenuBar bar;
	private JMenu edit, font;
	private JMenuItem item1, item2, item3, item4, item5, fstyle1, fstyle2, fstyle3, fstyle4;
	private int reglamentLevel;
	private Reglament reglament;
	private AdminSelectWindow window = new AdminSelectWindow();
	
	private JButton saveButton = CreateButton("Сохранить", 20, 420, 120, 30);
	private JButton back = CreateButton("Назад", 150, 420, 120, 30);
	private JButton loadDefault = CreateButton("Создать структуру регламента", 20, 370, 250, 30);

	/**
	 * Создание конструктора для класса окна создания регламента
	 * @param reglamentLevel Уровень регламента, требуемый для создания отдельного экземпляра этого окна
	 */
	public InstallReglamentWindow(int reglamentLevel) {
		this.reglamentLevel = reglamentLevel;
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
	private void spawn(int n) {
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основной текстовой панели с параметром false, недопускающим редактирование
		 */
		mainTextPanel = CreateMainTextPanel(true);
		/**
		 * Создание основного фрейма, задание названия, задания уровня регламента, прикрепление к панели
		 */
		mainFrame = CreateMainFrame("Создание регламента для уровня доступа ", reglamentLevel, mainPanel);
		/**
		 * Создания панели с ползунком, прикрепление к текстовой панели
		 */
		scrollPane = createScrollPane(mainTextPanel);
		/**
		 * Создания экземплеяра объекта типа Reglament, установка уровня,
		 * установка пустого названия, содержания и привязка к текстовой панели
		 */
		reglament = new Reglament(n, "", "", mainTextPanel);
		/**
		 * Установка шрифта на текстовую панель
		 */
		mainTextPanel.setFont(abcde);

		
		/**
		 * Создание элементов меню действий, задания им названия
		 */
		item1 = createMenuItem("Копировать (Ctrl + C)");
		item2 = createMenuItem("Вырезать (Ctrl + X)");
		item3 = createMenuItem("Вставить (Ctrl + V)");
		item4 = createMenuItem("Выбрать все (Ctrl + A)");
		item5 = createMenuItem("Удалить");

		/**
		 * Создание элементов меню изменяния шрифта, задания им названия
		 */
		fstyle1 = createMenuItem("Обычный");
		fstyle2 = createMenuItem("Жирный");
		fstyle3 = createMenuItem("Курсив");
		fstyle4 = createMenuItem("Жирный курсив");

		/**
		 * Задания названий для меню
		 */
		edit = createMenu("Действия");
		font = createMenu("Шрифт");

		/**
		 * Содзание панели меню
		 */
		bar = createMenuBar();

		/**
		 * Добавление элементов меню на меню
		 */
		addMenuItemToMenu(item1, edit);
		addMenuItemToMenu(item2, edit);
		addMenuItemToMenu(item3, edit);
		addMenuItemToMenu(item4, edit);
		addMenuItemToMenu(item5, edit);
		addMenuItemToMenu(fstyle1, font);
		addMenuItemToMenu(fstyle2, font);
		addMenuItemToMenu(fstyle3, font);
		addMenuItemToMenu(fstyle4, font);

		/**
		 * Добавления меню на панель
		 */
		addMenuToMenuBar(edit, bar);
		addMenuToMenuBar(font, bar);

		/**
		 * Добавление панели меню к фрейму
		 */
		addMenuBarToFrame(bar, mainFrame);
		
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(mainFrame, scrollPane);
		addComponentToFrame(mainFrame, saveButton);
		addComponentToFrame(mainFrame, back);
		addComponentToFrame(mainFrame, loadDefault);



		/**
		 * Создание слушателей для кнопок меню
		 */
		/**
		 * Создание слушателя для кнопки копирования выделенного текста
		 */
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				temp1 = mainTextPanel.getSelectedText();
			}
		});
		/**
		 * Создание слушателя для кнопки вырезания выделенного текста
		 */
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				temp1 = mainTextPanel.getSelectedText();
				/**
				 * Если выделенный текст присутствует (Метод getSelectedText() возвращает null,
				 * если ничего не было выделено
				 */
				if (temp1 != null) {
					/**
					 * Запись расположения в основном тексте первого символа выделенного текста в переменную
					 */
					temp2 = mainTextPanel.getText().indexOf(temp1);
					/**
					 * Замена выделенного текста пустой строкой
					 */
					mainTextPanel.replaceRange("", temp2, temp2 + temp1.length());
				}
			}
		});
		/**
		 * Создание слушателя для кнопки вставки сохраненного текста
		 */
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись расположения каретки относительного основного текста в переменную
				 */
				temp2 = mainTextPanel.getCaretPosition();
				/**
				 * Вставка сохраненного текста в место расположения каретки
				 */
				mainTextPanel.insert(temp1, temp2);
			}
		});
		/**
		 * Создание слушателя для кнопки выделения всего текста
		 */
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись длинны текста в переменную
				 */
				temp2 = mainTextPanel.getText().length();
				/**
				 * Выбор текста
				 */
				mainTextPanel.select(0,temp2);
			}
		});

		/**
		 * Создание слушателя для кнопки удаления текста
		 */
		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Запись выделенного фрагмента текста в строку
				 */
				del = mainTextPanel.getSelectedText();
				/**
				 * Если выделенный текст присутствует (Метод getSelectedText() возвращает null,
				 * если ничего не было выделено
				 */
				if (del != null) {
					/**
					 * Запись расположения в основном тексте первого символа выделенного текста в переменную
					 */
					temp2 = mainTextPanel.getText().indexOf(del);
					/**
					 * Замена выделенного текста пустой строкой
					 */
					mainTextPanel.replaceRange(" ", temp2, temp2 + del.length());
				}
			}
		});
		
		/**
		 * Создание слушателей для кнопки изменения стиля текста
		 */
		fstyle1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на обычный
				 */
				setFontStyle(abcde,Font.PLAIN,mainTextPanel);
			}
		});
		fstyle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на жирный
				 */
				setFontStyle(abcde,Font.BOLD,mainTextPanel);
			}
		});
		fstyle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на курсив
				 */ 
				setFontStyle(abcde,Font.ITALIC,mainTextPanel);
			}
		});
		fstyle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Вызов метода изменения стиля на жирный курсив
				 */
				setFontStyle(abcde,Font.ITALIC | Font.BOLD,mainTextPanel);
			}
		});
		

		/**
		 * Создания слушателя для кнопки сохранения
		 */
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Установка содержимого регламента
					 */
					reglament.setReglamentContent(mainTextPanel);
					/**
					 * Вызов метода, сохраняющего регламент на диск
					 */
					reglament.savePermanently();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * Создания слушателя для загрузки структуры регламента
		 */
		loadDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Установка содержимого регламента
					 */
					reglament.setReglamentContent(mainTextPanel);
					/**
					 * Вызов метода, загружающего структуру регламента
					 */
					reglament.loaddefault();
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
				 * Вызов окна администрирования
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
