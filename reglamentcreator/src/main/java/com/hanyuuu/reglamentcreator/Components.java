package com.hanyuuu.reglamentcreator;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Components {
	/**
	 * Метод, создающий и возвращающий фрейм с заданными параметрами:
	 * @param label Название фрейма
	 * @param add Панель, к которой будет прикрепляться фрейм
	 * @param x Начальная позиция X на фрейме для размещения элементов
	 * @param y Начальная позиция Y на фрейме для размещения элементов
	 * @param h Высота фрейма
	 * @param w Ширина фрейма
	 * @return Возвращаемый методом фрейм с примененными параметрами
	 */
	protected JFrame CreateMainFrame(String label, JPanel add, int x, int y, int h, int w) {
		/**
		 * Объявление и инициализация фрейма, привязка названия фрейма
		 */
		JFrame mainFrame = new JFrame(label);
		/**
		 * Установка действия при нажатии на кнопку выхода
		 */
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * Установка размеров фрейма и начальной позиции для размещения элементов
		 */
		mainFrame.setBounds(x, y, h, y);
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
	 * Метод, устанавливающий панель на фрейм
	 * @param a Фрейм, передаваемый методу как параметр
	 * @param b Панель, передаваемая методу как параметр
	 */
	protected void addcontent(JFrame a, JPanel b) {
		a.setContentPane(b);
	}
	/**
	 * Метод, устанавливающий компонент на фрейм
	 * @param a Фрейм, передаваемый методу как параметр
	 * @param b Элемент для установки на данный фрейм
	 */
	protected void addComponentToFrame(JFrame a, JComponent b) {
		a.add(b);
	}
	/**
	 * Метод, создающий и возвращающий лейбл с заданными параметрами:
	 * @param label Строка, используемая для установки надписи на лейбле
	 * @param x Начальная позиция X лейбла для размещения его на фрейме
	 * @param y Начальная позиция Y лейбла для размещения его на фрейме
	 * @param h Высота лейбла
	 * @param w Ширина лейбла
	 * @return Возвращаемый методом лейбл с примененными параметрами
	 */
	protected JLabel CreateLabel(String label, int x,int y,int w,int h) {
		/**
		 * Объявление и инициализация лейбла, привязка названия к лейблу
		 */
		JLabel a = new JLabel(label);
		/**
		 * Установка размеров лейбла и начальной позиции для его размещения на фрейме
		 */
		a.setBounds(x, y, w, h);
		return a;
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
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		a.setBounds(x,y,h,w);
		return a;
	}
}

