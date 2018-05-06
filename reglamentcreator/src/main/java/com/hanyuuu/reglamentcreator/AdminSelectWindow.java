package com.hanyuuu.reglamentcreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminSelectWindow extends Components {
	/**
	 * Объявление элементов:
	 * 
	 * mainPanel – Основная панель
	 * mainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * mainLabel – Лейбл для отображения надписи "Коэф. регламентов:"
	 * info – Лейбл для отображения значения коэффициента регламентов
	 * level1 – Кнопка для перехода к созданию регламента уровня доступа 1
	 * level2 – Кнопка для перехода к созданию регламента уровня доступа 2
	 * level3 – Кнопка для перехода к созданию регламента уровня доступа 3
	 * back – Кнопка для перехода в основное меню программы
	 * window – Класс окна создания регламента
	 * Swindow – Класс основного окна
	 * a – Класс, содержащий расчеты коэффициента регламента
	 * f – Переменная, в которой будет храниться коэффициент регламента
	 */
	private JPanel mainPanel;
	private JFrame mainFrame;
	private JLabel mainLabel;
	private JLabel info;
	private JButton level1;
	private JButton level2;
	private JButton level3;
	private JButton back;
	private InstallReglamentWindow window;
	private SelectWindow Swindow;
	private coefficient_func a;
	private int f;

	/**
	 * Метод запускающий окно администрирования
	 */
	private void spawn() {
		/**
		 * Инициализация функции расчет коэффициента регламента
		 */
		a = new coefficient_func();
		/**
		 * Расчет коэффициента регламента и запись результата в переменную f
		 */
		try {
			f = a.takeSum(a.getNumOfSymbols(1), a.getNumOfSymbols(2), a.getNumOfSymbols(3));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основного фрейма, задание названия, прикрепление к панели, задание начальных координат и размеров фрейма
		 */
		mainFrame = CreateMainFrame("Привязка регламента", mainPanel, 300, 200, 366, 233);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 1, задание названия кнопки и ее размеров
		 */
		level1 = CreateButton("Уровень доступа 1", 10, 10, 330, 30);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 2, задание названия кнопки и ее размеров
		 */
		level2 = CreateButton("Уровень доступа 2", 10, 50, 330, 30);
		/**
		 * Создание кнопки перехода к созданию регламента для уровня доступа 3, задание названия кнопки и ее размеров
		 */
		level3 = CreateButton("Уровень доступа 3", 10, 90, 330, 30);
		/**
		 * Создание кнопки возвращения к основному меню, задание названия, задание названия кнопки и ее размеров
		 */
		back = CreateButton("Назад", 10, 130, 80, 30);
		/**
		 * Создание лейбла для отображения надписи "Коэф. регламентов:", задание названия кнопки и ее размеров
		 */
		mainLabel = CreateLabel("Коэф. регламентов:", 100, 135, 130, 20);
		/**
		 * Создание лейбла для отображения значения коэффициента регламентов, задание названия кнопки и ее размеров
		 */
		info = CreateLabel(String.valueOf(f), 240, 135, 60, 20);

		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(mainFrame, level1);
		addComponentToFrame(mainFrame, level2);
		addComponentToFrame(mainFrame, level3);
		addComponentToFrame(mainFrame, back);
		addComponentToFrame(mainFrame, mainLabel);
		addComponentToFrame(mainFrame, info);

		/**
		 * Инициализация окна создания регламента
		 */
		window = new InstallReglamentWindow(0);
		/**
		 * Инициализация основного окна
		 */
		Swindow = new SelectWindow();
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(mainFrame);
		/**
		 * Создание слушателей для кнопок
		 */
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
				Swindow.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 1
		 */
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну создания регламента аргумент 1 (уровень создаваемого регламента)
				 */
				window.setLevel(1);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				window.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 2
		 */
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну создания регламента аргумент 2 (уровень создаваемого регламента)
				 */
				window.setLevel(2);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				window.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к созданию регламента для уровня доступа 3
		 */
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну создания регламента аргумент 3 (уровень создаваемого регламента)
				 */
				window.setLevel(3);
				/**
				 * Вызов метода инициализирующего граф. интерфейс этого окна
				 */
				window.init();
			}
		});
	}
	/**
	 * Публичный метод для вызова граф. интерфейса этого окна из других классов
	 */
	public void init() {
		spawn();
	}
}