/**
 * Установка принадлежности к пакету reglament_creator
 */
package com.hanyuuu.reglamentcreator;
/**
 * Импортирование класса, содержащего набор методов сравнения
 */
import static org.junit.Assert.assertEquals;
/**
 * Импортирование основного пакета для тестирования
 */
import org.junit.Test;
/**
 * Импортирование класса программы, подлежащего тестированию
 */
import com.hanyuuu.reglamentcreator.coefficient_func;
public class Func16Test {

	@Test
	public void test() {
		/**
		 * Входными данными является метод, выводящий результат расчета коэффициента регламента
		 * и предполагаемый результат данного расчета.
		 * Предполагается, что программой будет произведен расчет коэффициента регламента 
		 * по формуле x=a*1+b*2+b*3, где
		 * a – Количество символов в регламенте уровня 1
		 * b – Количество символов в регламенте уровня 2
		 * c – Количество символов в регламенте уровня 3
		 * Программе на вход даются 3 элемента регламента со следующими количествами символов
		 * на соответствующих уровнях: 300, 250, 200.
		 * Ожидается, что будет произведен следующий расчет: (300*1+250*2+200*3) и возвращено значение 1400
		 */
		/**
		 * Инициализация тестируемого класса
		 */
		coefficient_func a = new coefficient_func();
		/**
		 * Сравнение рассчитанного и ожидаемого значения
		 */
		assertEquals(a.takeSum(300, 250, 200),1400);
	}

}
