package com.hanyuuu.reglamentcreator;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ReglamentWindow {
	/**
	 * Метод, создающий и возвращающий текстовую панель с заданными параметрами:
	 * @param a Разрешение на изменение текста в панели
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JTextArea CreateMainTextPanel(boolean a) {
		/**
		 * Объявление и инициализация текстовой панели
		 */
		JTextArea mainTextPanel = new JTextArea();
		/**
		 * Установка размеров текстовой панели и начальной позиции для размещения
		 */
		mainTextPanel.setBounds(0, 0, 800, 360);
		/**
		 * Запрет на выход текста за границу панели
		 */
		mainTextPanel.setLineWrap(true);
		/**
		 * Установка разрешения на изменение
		 */
		mainTextPanel.setEditable(a);
		return mainTextPanel;
	};

	/**
	 * Метод, создающий и возвращающий панель с ползунком с заданными параметрами:
	 * @param b Текстовая панель, которая будет прикреплена к панели с ползунком
	 * @return
	 */
	protected JScrollPane createScrollPane(JTextArea b) {
		/**
		 * Объявление и инициализация панели с ползунком
		 */
		JScrollPane a = new JScrollPane(b);
		/**
		 * Установка вертикального ползунка
		 */
		a.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		/**
		 * Установка размеров панели с ползунком и начальной позиции для размещения
		 */
		a.setBounds(0, 0, 800, 350);
		/**
		 * Установка размеров панели с ползунком
		 */
		a.setSize(800, 360);
		return a;
	}
	/**
	 * Метод, создающий панель меню
	 * @return Возвращаемая панель меню
	 */
	protected JMenuBar createMenuBar() {
		JMenuBar a = new JMenuBar();
		return a;
	}
	/**
	 * Метод, создающий меню
	 * @return Возвращаемое меню
	 */
	protected JMenu createMenu(String label) {
		JMenu a = new JMenu(label);
		return a;
	}
	/**
	 * Метод, создающий элемент меню
	 * @param label Название элемента меню
	 * @return
	 */
	protected JMenuItem createMenuItem(String label) {
		JMenuItem a = new JMenuItem(label);
		return a;
	}

	/**
	 * Метод, добавляющий элемент меню на меню
	 * @param a Элемент меню
	 * @param b Меню
	 */
	protected void addMenuItemToMenu(JMenuItem a, JMenu b) {
		b.add(a);
	}

	/**
	 * Метод, добавляющий меню на панель меню
	 * @param a Меню
	 * @param b Панель меню
	 */
	protected void addMenuToMenuBar(JMenu a, JMenuBar b) {
		b.add(a);
	}

	/**
	 * Метод, добавляющий панель меню на фрейм
	 * @param a Панель меню
	 * @param b Фрейм
	 */
	protected void addMenuBarToFrame(JMenuBar a, JFrame b) {
		b.setJMenuBar(a);
	}


	/**
	 * Метод, создающий и возвращающий фрейм с заданными параметрами:
	 * @param label Название фрейма
	 * @param add Панель, к которой будет прикрепляться фрейм
	 * @param level Уровень регламента
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JFrame CreateMainFrame(String label, int level, JPanel add) {
		/**
		 * Объявление и инициализация фрейма, привязка названия фрейма
		 */
		JFrame mainFrame = new JFrame(label + level);
		/**
		 * Установка размеров фрейма
		 */
		mainFrame.setSize(800, 530);
		/**
		 * Установка панели для фрейма
		 */
		mainFrame.setContentPane(add);
		/**
		 * Установка запрета на изменение размеров
		 */
		mainFrame.setResizable(false);
		return mainFrame;
	};

	/**
	 * Метод, добавляющий панель на фрейм
	 * @param a Фрейм
	 * @param b Панель
	 */
	protected void addcontent(JFrame a, JPanel b) {
		a.setContentPane(b);
	}
	/**
	 * Метод, устанавливающий стиль шрифта
	 * @param a Изначальный шрифт
	 * @param b Новый стиль шрифта
	 * @param c Текстовая панель, к который должен быть применен шрифт
	 */
	public void setFontStyle(Font a, int b, JTextArea c) {
		/**
		 * Сохранение названия предыдущего шрифта
		 */
		String fontName = a.getName();
		/**
		 * Сохранение размера шрифта
		 */
		int fontSize = a.getSize();
		/**
		 * Создание нового шрифта с заданным стилем
		 */
		a = new Font(fontName, b, fontSize);
		/**
		 * Установка нового шрифта на текстовую панель
		 */
		c.setFont(a);
	}

	/**
	 * Метод, добавляющий элемент на фрейм
	 * @param a Фрейм
	 * @param b Компонент, прикрепляемый на фрейм
	 */
	protected void addComponentToFrame(JFrame a, JComponent b) {
		a.add(b);
	}
	/**
	 * Метод, делающий фрейм видимым
	 * @param a Фрейм, передаваемый методу как параметр
	 */
	protected void makeFrameVisible(JFrame a) {
		a.setVisible(true);
	}
	/**
	 * Метод, делающий фрейм невидимым
	 * @param a Фрейм, передаваемый методу как параметр
	 */
	protected void frameDespawn(JFrame a) {
		a.setVisible(false);
	}
	/**
	 * Метод создающий и возвращающий панель
	 * @return Возвращаемая панель
	 */
	protected JPanel CreateMainPanel() {
		/**
		 * Объявление и инициализация панели
		 */
		JPanel mainPanel = new JPanel();
		/**
		 * Установка границ для панели
		 */
		mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		/**
		 * Установка способа размещения элементов на панели
		 */
		mainPanel.setLayout(null);
		return mainPanel;
	}


	/**
	 * Метод, создающий и возвращающий кнопку с заданными параметрами:
	 * @param alo Строка, используемая для установки надписи на кнопке
	 * @param x Начальная позиция X кнопки для размещения её на фрейме
	 * @param y Начальная позиция Y кнопки для размещения её на фрейме
	 * @param h Высота кнопки
	 * @param w Ширина кнопки
	 * @return Возвращаемая методом кнопка с примененными параметрами
	 */
	protected JButton CreateButton(String alo, int x, int y, int h, int w) {
		/**
		 * Объявление и инициализация кнопки, установка названия
		 */
		JButton a = new JButton(alo);
		/**
		 * Установка границ для кнопки
		 */
		a.setBounds(x, y, h, w);
		return a;
	}
}