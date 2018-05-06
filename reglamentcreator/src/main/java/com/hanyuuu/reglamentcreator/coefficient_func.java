package com.hanyuuu.reglamentcreator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class coefficient_func {
	/**
	 * Метод, считающий количество символов в регламенте определенного уровня
	 * lvl – значение уровня
	 */
	public int getNumOfSymbols(int lvl) throws IOException {
		/**
		 * Считывание символов файла в строку f
		 */
		String f = new String(Files.readAllBytes(Paths.get("ReglamentForLevel " + lvl +".reglament")));
		/**
		 * Запись длинны данной строки
		 */
		int num = f.length();
		return num;
	}
	/**
	 * Функция расчета коэффициента регламента
	 * Входные значения:
	 * lvl1 – количество символов в регламенте уровня 1
	 * lvl2 – количество символов в регламенте уровня 2
	 * lvl3 – количество символов в регламенте уровня 3
	 */
	public int takeSum(int lvl1, int lvl2, int lvl3) {
		/**
		 * Расчет коэффициента регламента
		 */
		int totalSum = lvl1 + lvl2*2 + lvl3*3;
		return totalSum;
	}
}
