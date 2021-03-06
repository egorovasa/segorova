package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *ConverterTest.
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class ConverterTest {
	/**
	 *Test rubleToEuro.
	 */ @Test
	public void when70RubleToEuroThen1() {
		Converter converter = new Converter();
		double result = converter.rubleToEuro(70);
		assertThat(result, is(1D));
	}
	/**
	 *Test euroToRuble.
	 */ @Test
	public void when1EuroToRubleThen70() {
		Converter converter = new Converter();
		double result = converter.euroToRuble(1);
		assertThat(result, is(70D));
	}
	/**
	 *Test rubleToDollar.
	 */ @Test
	public void when60RubleToDollarThen1() {
		Converter converter = new Converter();
		double result = converter.rubleToDollar(60);
		assertThat(result, is(1D));
	}
	/**
	 *Test dollarToRuble.
	 */ @Test
	public void when1DollarToRubleThen60() {
		Converter converter = new Converter();
		double result = converter.euroToRuble(1);
		assertThat(result, is(70D));
	}
}