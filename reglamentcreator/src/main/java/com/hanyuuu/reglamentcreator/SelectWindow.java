package com.hanyuuu.reglamentcreator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectWindow extends Components {
	/**
	 * Объявление элементов:
	 * 
	 * mainPanel – Основная панель
	 * mainFrame – Основная рамка, на которую будут прикрепляться все элементы
	 * mainLabel – Лейбл для отображения надписи "Коэф. регламентов:"
	 * admin – Кнопка для перехода в окно администрирования
	 * level1 – Кнопка для перехода к просмотру регламента уровня доступа 1
	 * level2 – Кнопка для перехода к просмотру регламента уровня доступа 2
	 * level3 – Кнопка для перехода к просмотру регламента уровня доступа 3
	 * window – Экземпляр объекта окна администрирования
	 * InWin – Экземпляр объекта окна просмотра регламента
	 */
	private JPanel mainPanel;
	private JFrame mainFrame;
	private JButton admin;
	private JButton level1;
	private JButton level2;
	private JButton level3;
	private AdminSelectWindow window;
	private InspectReglamentWindow InWin;

	/**
	 * Метод, запускающий программу
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/**
				 * Создание экземпляра основного окна
				 */
				SelectWindow a = new SelectWindow();
				/**
				 * Запуск основного окна
				 */
				a.init();
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Метод запускающий основное окно
	 */
	private void spawn() {
		/**
		 * Инициализация окна просмотра регламента
		 */
		InWin = new InspectReglamentWindow(0);
		/**
		 * Инициализация окна администратора
		 */
		window = new AdminSelectWindow();
		/**
		 * Создание основной панели
		 */
		mainPanel = CreateMainPanel();
		/**
		 * Создание основного фрейма, задание названия, прикрепление к панели, задание начальных координат и размеров фрейма
		 */
		mainFrame = CreateMainFrame("Формирование регламента", mainPanel, 300, 200, 366, 233);
		/**
		 * Создание кнопки перехода к окну администратора, задание названия, задание названия кнопки и ее размеров
		 */
		admin = CreateButton("Администрирование", 10, 10, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 1, задание названия кнопки и ее размеров
		 */
		level1 = CreateButton("Уровень доступа 1", 10, 50, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 2, задание названия кнопки и ее размеров
		 */
		level2 = CreateButton("Уровень доступа 2", 10, 90, 330, 30);
		/**
		 * Создание кнопки перехода к просмотру регламента для уровня доступа 3, задание названия кнопки и ее размеров
		 */
		level3 = CreateButton("Уровень доступа 3", 10, 130, 330, 30);
		/**
		 * Добавление всех компонентов на фрейм
		 */
		addComponentToFrame(mainFrame, level1);
		addComponentToFrame(mainFrame, level2);
		addComponentToFrame(mainFrame, level3);
		addComponentToFrame(mainFrame, admin);
		/**
		 * Установка фрейма видимым
		 */
		makeFrameVisible(mainFrame);
		/**
		 * Создание слушателей для кнопок
		 */
		/**
		 * Создание слушателя для кнопки перехода к окну администратора
		 */
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна администратора
				 */
				window.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 1
		 */
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 1 (уровень просматриваемого регламента)
				 */
				InWin.setLevel(1);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InWin.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 2
		 */
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 2 (уровень просматриваемого регламента)
				 */
				InWin.setLevel(2);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InWin.init();
			}
		});
		/**
		 * Создание слушателя для кнопки перехода к просмотру регламента для уровня доступа 3
		 */
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Установка фрейма невидимым
				 */
				frameDespawn(mainFrame);
				/**
				 * Передача окну просмотра регламента аргумент 3 (уровень просматриваемого регламента)
				 */
				InWin.setLevel(3);
				/**
				 * Вызов метода инициализирующего граф. интерфейс окна просмотра регламента
				 */
				InWin.init();
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
