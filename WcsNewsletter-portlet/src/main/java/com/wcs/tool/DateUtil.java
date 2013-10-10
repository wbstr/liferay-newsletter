package com.wcs.tool;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 Webstar Csoport Kft.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static final String SIMPLE_DATE_FORMAT_HU = "yyyy.MM.dd";
    public static final String DATE_FORMAT_XSD_TYPE = "yyyy-MM-dd";
    public static final String DATE_FORMAT_HU = "yyyy. MMMMM dd.";
    public static final String DATE_FORMAT_SHORT = "yyyyMMdd";
    public static final String TIME_FORMAT_HU = "yyyy.MM.dd HH:mm";
    public static final String TIME_FORMAT_SEC_LEVEL = "yyyy.MM.dd HH:mm:ss";
    public static final String TIME_FORMAT_SHORT = "yyMMddHHmm";
    public static final String TIME_FORMAT_WITH_TIMEZONE = "yyyy-MM-dd'T'hh:mm:ssz";
    public static final long HOUR_IN_MILLIS = 60 * 60 * 1000;
    public static final long DAY_IN_MILLIS = 24 * HOUR_IN_MILLIS;
    public static final Locale HUNGARY_LOCALE = new Locale("hu", "HU");

    private static SimpleDateFormat dateFormatter(String dateFormat) {
        return new SimpleDateFormat(dateFormat);
    }

    private static SimpleDateFormat dateFormatter(String dateFormat, Locale locale) {
        return new SimpleDateFormat(dateFormat, locale);
    }

    private static SimpleDateFormat dateFormatter(boolean simple) {
        return dateFormatter(simple ? SIMPLE_DATE_FORMAT_HU : DATE_FORMAT_HU);
    }

    private static SimpleDateFormat timeFormatter() {
        return dateFormatter(TIME_FORMAT_HU);
    }

    private static SimpleDateFormat timeFormatterSecLevel() {
        return dateFormatter(TIME_FORMAT_SEC_LEVEL);
    }

    public static String dateToString(final Date date, final String dateFormat) {
        return dateToString(date, dateFormat, Locale.getDefault());
    }

    public static String dateToString(final Date date, final String dateFormat, final Locale locale) {
        if (date == null || dateFormat == null) {
            return "";
        }
        return dateFormatter(dateFormat, locale).format(date);
    }

    public static String dateToString(final Date date) {
        return dateToString(date, SIMPLE_DATE_FORMAT_HU);
    }

    /**
     * Ha év és hét (yyyy.ww) alapján hozunk létre dátumot, az RFC822 szabvány szerinti hét lesz, nem pedig ISO8601 szerinti!
     */
    public static Date stringToDate(final String str, final String dateFormat) {
        return stringToDate(str, dateFormat, Locale.getDefault());
    }
    
    /**
     * Ha év és hét (yyyy.ww) alapján hozunk létre dátumot, az RFC822 szabvány szerinti hét lesz, nem pedig ISO8601 szerinti!
     */
    public static Date stringToDate(final String str, final String dateFormat, final Locale locale) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        try {
            return dateFormatter(dateFormat, locale).parse(str);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date stringToDate(final String str) {
        return stringToDate(str, SIMPLE_DATE_FORMAT_HU);
    }
    
    public static Timestamp dateToTimestamp(final Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Timestamp stringToTimestamp(final String str) {
        return dateToTimestamp(stringToDate(str));
    }

    public static String timestampToString(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timeFormatter().format(timestamp);
    }

    public static Date createDateAndTime(final int ev, final int ho, final int nap, final int ora, final int perc) {
        return createDateAndTime(createDate(ev, ho, nap), ora, perc);
    }

    /*
     * datum adja a datumot, oraPerc-bol jon az ora:perc
     */
    public static Date makeFromDateAndTime(final Date datum, final Date oraPerc) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(oraPerc);
        int ora = cal.get(Calendar.HOUR_OF_DAY);
        int perc = cal.get(Calendar.MINUTE);
        return createDateAndTime(datum, ora, perc);
    }

    /**
     * datum adja a datumot, ora, perc-bol jon az ora:perc
     */
    public static Date createDateAndTime(final Date datum, final int ora, final int perc) {
        if (!isValidHour(ora) || !isValidMinute(perc)) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, ora);
        cal.set(Calendar.MINUTE, perc);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date createDateAndTime(final Date datum, final int ora, final int perc, final int sec) {
        if (!isValidHour(ora) || !isValidMinute(perc) || !isValidSec(sec)) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, ora);
        cal.set(Calendar.MINUTE, perc);
        cal.set(Calendar.SECOND, sec);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static boolean isValidMinute(final int min) {
        return min >= 0 && min < 60;
    }

    public static boolean isValidHour(final int hour) {
        return hour >= 0 && hour < 24;
    }

    public static boolean isValidSec(final int sec) {
        return sec >= 0 && sec < 60;
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Timestamp getCurrentTimestamp() {
        return dateToTimestamp(getCurrentDate());
    }

    public static Date add(Date eredeti, int mihez, int mennyit) {
        if (eredeti == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(eredeti);
        cal.add(mihez, mennyit);

        return cal.getTime();
    }

    public static Date addMonths(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.MONTH, mennyit);
    }

    public static Date addWeeks(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.WEEK_OF_YEAR, mennyit);
    }

    public static Date addDays(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.DAY_OF_YEAR, mennyit);
    }

    public static Date addYears(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.YEAR, mennyit);
    }

    public static Date addMinutes(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.MINUTE, mennyit);
    }

    public static Date addSecond(Date eredeti, int mennyit) {
        return add(eredeti, Calendar.SECOND, mennyit);
    }

    public static java.sql.Date stringToSqlDate(String str) {
        return dateToSqlDate(stringToDate(str));
    }

    public static java.sql.Date dateToSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    public static java.sql.Date getCurrentSQLDate() {
        return dateToSqlDate(getCurrentDate());
    }

    // visszaadja az adott napot 0 ora 0 perc  0 sec 0 ms -el
    public static Date startOfDay(Date datum) {
        if (datum == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(datum);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }
    
    /**
     * Megadja egy dátum alapján az őt körülfoglaló hét legelejét.
     * @param datum a hét egy tetszőleges időpontja
     * @return a hét hétfőjének 0 óra 0 perce, 0 másodperce 0 ezredmásodperce
     */
    public static Date startOfWeek(Date datum) {
        if (datum == null) {
            return null;
        }
        Calendar c = new GregorianCalendar();
        c.setTime(datum);
        while (c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            c.setTime(addDays(c.getTime(), -1));
        }
        return startOfDay(c.getTime());
    }

    // visszaadja az adott napot 23 óra 59 perc 59 sec 999 ms-el
    public static Date endOfDay(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    public static Date startOfMonth(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return cal.getTime();
    }

    public static boolean isWeekEnd(Date datum) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(datum);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static String dateToStringVerbose(Date date) {
        if (date == null) {
            return null;
        }
        return dateFormatter(false).format(date);
    }

    public static long dayDiff(Date a, Date b) {
        if (a == null || b == null) {
            return 0;
        }

        long diff = a.getTime() - b.getTime();

        //egy orat a teli-nyari idoszamitas miatt korrigalunk (van 23 oras nap is)
        if (diff >= 0) {
            diff = diff + HOUR_IN_MILLIS;
        } else {
            diff = diff - HOUR_IN_MILLIS;
        }

        return diff / DAY_IN_MILLIS;
    }

    public static long dayDiffByStartOfDay(Date a, Date b) {
        a = startOfDay(a);
        b = startOfDay(b);
        return dayDiff(a, b);
    }

    public static Date sameTimeTomorrow() {
        return addDays(getCurrentDate(), 1);
    }

    public static Date sameTimeTomorrow(Date time) {
        if (time == null) {
            return null;
        }
        return makeFromDateAndTime(tomorrow(), time);
    }

    public static Date sameTimeToday(Date time) {
        if (time == null) {
            return null;
        }
        return makeFromDateAndTime(today(), time);
    }

    public static boolean isSameDay(Date a, Date b) {
        if (a == null || b == null) {
            return false;
        }

        Calendar ca = new GregorianCalendar();
        ca.setTime(a);
        Calendar cb = new GregorianCalendar();
        cb.setTime(b);

        return ca.get(Calendar.YEAR) == cb.get(Calendar.YEAR)
                && ca.get(Calendar.MONTH) == cb.get(Calendar.MONTH)
                && ca.get(Calendar.DAY_OF_MONTH) == cb.get(Calendar.DAY_OF_MONTH);
    }

    public static String dateToStringSecLevel(Date d) {
        if (d == null) {
            return null;
        }
        return timeFormatterSecLevel().format(d);
    }

    public static String getCurrentTimeStr() {
        return dateToStringSecLevel(getCurrentDate());
    }

    public static String getCurrentDateStr() {
        return dateToString(getCurrentDate());
    }

    public static String getTimeStrShort(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat(TIME_FORMAT_SHORT);
        return formatter.format(d);
    }

    // visszaadja az aktualis napot 0 ora 0 perc  0 sec 0 ms -el	
    public static Date today() {
        return startOfDay(getCurrentDate());
    }

    // visszaadja az holnapi napot 0 ora 0 perc  0 sec 0 ms -el	
    public static Date tomorrow() {
        return startOfDay(addDays(getCurrentDate(), 1));
    }

    // visszaadja az tegnapi napot 0 ora 0 perc  0 sec 0 ms -el	
    public static Date yesterday() {
        return startOfDay(addDays(getCurrentDate(), -1));
    }

    public static boolean sameYearAndMonth(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return false;
        }
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d1);
        Calendar c2 = new GregorianCalendar();
        c2.setTime(d2);

        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
    }

    /**
     * Nap szintű between, befoglaló
     *
     * @param most
     * @param kezdet
     * @param veg
     * @return
     */
    public static boolean between(Date kezdet, Date veg, Date datum) {
        if (datum == null || kezdet == null || veg == null) {
            return false;
        }

        Date day = startOfDay(datum);

        return !day.before(startOfDay(kezdet)) && !day.after(startOfDay(veg));
    }

    public static boolean between(Date kezdet, Date veg) {
        return between(kezdet, veg, today());
    }

    public static boolean nullEnabledBetween(Date kezdet, Date veg) {
        Date datum = today();
        if (kezdet == null) {
            if (veg != null) {
                return datum.before(veg);
            } else {
                return true;
            }
        }

        if (veg == null) {
            if (kezdet != null) {
                return datum.after(kezdet);
            } else {
                return true;
            }
        }

        Date day = startOfDay(datum);

        return !day.before(startOfDay(kezdet)) && !day.after(startOfDay(veg));
    }

    /**
     * True, ha ((kezdet kisebb vagy egyenlő dátum) ÉS (dátum kisebb vagy
     * egyenlő vég)). False: ha a feltétel nem teljesül, vagy ha a dátum null.
     * Ha a kezdet null, mínusz végtelennek veszi. Ha a vég null, plusz
     * végtelennek veszi.
     *
     * @param kezdet A vizsgált intervallum kezdete
     * @param datum A dátum, amiről el kell dönteni, benne van-e az
     * intervallumban.
     * @param veg A vizsgált intervallum vége
     */
    public static boolean betweenStrict(Date kezdet, Date datum, Date veg) {
        //TODO: DateUtil: betweenStrict() nincs tesztelve!
        if (datum == null) {
            return false;
        }
        if (kezdet != null && datum.before(kezdet)) {
            return false;
        }
        if (veg != null && datum.after(veg)) {
            return false;
        }
        return true;
    }

    /**
     * Eldönti, hogy a megadott 'A' és 'B' intervallum fedésben van-e egymással.
     * 'A' és 'B' intervallum is balról zárt, jobbról nyitott. True, ha az
     * intervallumok fedésben vannak, egyébként false. Ha az egyik vége
     * megegyezik a másik végével, akkor is false-t ad vissza! Ha bármelyik
     * paraméter null, az az adott irányban végtelenbe nyúló határt jelent. Az
     * intervallumoknak helyesnek kell lenniük. Ha bármelyik intervallum eleje
     * később van, mint a vége, a metódus null-al tér vissza!
     *
     * @param aStart: 'A' intervallum kezdete.
     * @param aEnd: 'A' intervallum vége.
     * @param bStart: 'B' intervallum kezdete.
     * @param bEnd: 'B' intervallum vége.
     */
    public static Boolean overlappedIntervals(Date aStart, Date aEnd, Date bStart, Date bEnd) {
        if (aEnd != null && aStart != null && aEnd.before(aStart)) {
            System.out.println("DateUtil.overlappedIntervals(): Az 'A' intervallum eleje későbbi a végénél, így a metódus null-al tér vissza!");
            return null;
        }
        if (bEnd != null && bStart != null && bEnd.before(bStart)) {
            System.out.println("DateUtil.overlappedIntervals(): A 'B' intervallum eleje későbbi a végénél, így a metódus null-al tér vissza!");
            return null;
        }

        // o---o  o===o eset:
        if (aStart != null && aEnd != null && bStart != null && bEnd != null && !aEnd.after(bStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 1");
            return false;
        }

        // o---o  o==== eset:
        if (aStart != null && aEnd != null && bStart != null && bEnd == null && !aEnd.after(bStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 2");
            return false;
        }

        // ----o  o===o eset:
        if (aStart == null && aEnd != null && bStart != null && bEnd != null && !aEnd.after(bStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 3");
            return false;
        }

        // ----o  o==== eset:
        if (aStart == null && aEnd != null && bStart != null && bEnd == null && !aEnd.after(bStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 4");
            return false;
        }

        // o===o  o---o eset:
        if (bStart != null && bEnd != null && aStart != null && aEnd != null && !bEnd.after(aStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 5");
            return false;
        }

        // o===o  o---- eset:
        if (bStart != null && bEnd != null && aStart != null && aEnd == null && !bEnd.after(aStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 6");
            return false;
        }

        // ====o  o---o eset:
        if (bStart == null && bEnd != null && aStart != null && aEnd != null && !bEnd.after(aStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 7");
            return false;
        }

        // ====o  o---- eset:
        if (bStart == null && bEnd != null && aStart != null && aEnd == null && !bEnd.after(aStart)) {
            System.out.println("DateUtil.overlappedIntervals(): 8");
            return false;
        }

        // minden más esetben átfedés van:
        System.out.println("DateUtil.overlappedIntervals(): átfedés van!");
        return true;
    }

    /*
     * visszaadja egy idozitett task kovetkezo futasanak idejet a bejovo
     * time-bol csak a napon beluli idopontot hasznaljuk ha meg nem mult el ma
     * ez az idopont, akkor mara, egyebkent holnapra utemezzuk a feladatot
     */
    public static Date nextTimeForScheduledTask(Date time) {
        Date now = getCurrentDate();
        Date sameTimeToday = sameTimeToday(time);
        return sameTimeToday.after(now) ? sameTimeToday : sameTimeTomorrow(time);
    }

    /*
     * Itt 1<=month<=12 !!!
     */
    public static Date createDate(int year, int month, int day) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return startOfDay(c.getTime());
    }

    public static int getCurrentYear() {
        Calendar c = new GregorianCalendar();
        c.setTime(getCurrentDate());
        return c.get(Calendar.YEAR);
    }

    public static int getCurrentWeekOfYear() {
        Calendar c = new GregorianCalendar();
        c.setTime(getCurrentDate());
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfYear(Date date, Locale locale) {
        Calendar c = new GregorianCalendar(locale);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }
    
    public static int getWeekOfYear(Date date) {
        return getWeekOfYear(date, Locale.getDefault());
    }

    public static int getDayOfMonth(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }
    
    public static int getCurrentDayOfWeek(){
        Calendar c = new GregorianCalendar();
        c.setTime(getCurrentDate());
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int getCurrentDayOfMonth() {
        Calendar c = new GregorianCalendar();
        c.setTime(getCurrentDate());
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getWeeksInYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, 11, 31);
        return c.get(Calendar.WEEK_OF_YEAR) == 53 ? 53 : 52;
    }

    public static int getWeeksInYear() {
        return getWeeksInYear(getCurrentYear());
    }

    public static int getYear(final Date date) {
        if (date == null) {
            return 0;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static Date firstDayOfYear(final int year) {
        return createDate(year, 1, 1);
    }

    /**
     *
     * @param century (positive integer)
     * @return
     */
    public static int firstYearOfCentury(final int century) {
        return (century - 1) * 100 + 1;
    }

    /**
     *
     * @param century (positive integer)
     * @return
     */
    public static Date firstDayOfCentury(final int century) {
        return firstDayOfYear(firstYearOfCentury(century));
    }

    public static boolean isBeforeCentury(final Date date, final int century) {
        if (date == null) {
            return false;
        }
        return date.before(firstDayOfCentury(century));
    }

    public static boolean isInCentury(final Date date, int century) {
        if (date == null) {
            return false;
        }
        return isBeforeCentury(date, century + 1) && !isBeforeCentury(date, century);
    }

    /*
     * nap szintu jovobeliseg ellenorzes
     */
    public static boolean isInFuture(final Date date) {
        if (date == null) {
            return false;
        }
        return startOfDay(date).after(today());
    }

    /*
     * nap szintu multbeliseg ellenorzes
     */
    public static boolean isInPast(final Date date) {
        if (date == null) {
            return false;
        }
        return startOfDay(date).before(today());
    }

    /*
     * nap szintu jelenbeliseg ellenorzes
     */
    public static boolean isToday(final Date date) {
        if (date == null) {
            return false;
        }
        return !isInPast(date) && !isInFuture(date);
    }

    /**
     * Visszaadja hogy a megadott dátum a hét melyik napja 1 vasárnap 7 szombat
     *
     * @param date
     * @return
     */
    public static int dayOfWeek(final Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    /**
     * Visszaadja a megadott dátumhoz tartozó hét hétfői napját
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(final Date date) {
        if (dayOfWeek(date) == 1) {
            return addDays(date, -6);
        }
        return addDays(date, -1 * (dayOfWeek(date) - 2));
    }

    /**
     * Megadja egy személy korát hónapokban mérve.
     *
     * @param birth : a születés dátuma
     * @param now : a jelen dátuma
     * @return Ha a születés dátuma korábbi a megadott jelen dátumánál, a
     * megadott jelen és a születés dátumának hónapokban mért különbségét adja,
     * különben 0-t.
     */
    public static int getMonthsOfAge(Date birth, Date now) {
        Calendar nowCalendar = new GregorianCalendar();
        Calendar birthCalendar = new GregorianCalendar();
        birthCalendar.setTime(birth);
        nowCalendar.setTime(now);
        if (nowCalendar.getTimeInMillis() > birthCalendar.getTimeInMillis()) {
            int months = nowCalendar.get(Calendar.MONTH) - birthCalendar.get(Calendar.MONTH);
            int yearDiff = nowCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            if (yearDiff > 0) {
                months = yearDiff * 12 + months;
            }
            if (nowCalendar.get(Calendar.DAY_OF_MONTH) < birthCalendar.get(Calendar.DAY_OF_MONTH)) {
                months--;
            }
            return months;
        } else {
            return 0;
        }
    }

    public static int getYearsOfAge(Date birthDate, Date nowDate) {
        Calendar birth = new GregorianCalendar();
        birth.setTime(birthDate);
        Calendar now = new GregorianCalendar();
        now.setTime(nowDate);
        int year = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if ((birth.get(Calendar.MONTH) > now.get(Calendar.MONTH))
                || (birth.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                && birth.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
            year--;
        }
        return year;
    }

    public static Date max(Date datum1, Date datum2) {
        if (datum1 == null) {
            return datum2;
        }

        if (datum2 == null) {
            return datum1;
        }

        return datum2.after(datum1) ? datum2 : datum1;
    }

    public static Date max(Collection<Date> datumok) {
        Collection<Date> nemNullDatumok = new ArrayList<Date>();
        for (Date date : datumok) {
            if (date != null) {
                nemNullDatumok.add(date);
            }
        }
        Date max = nemNullDatumok.isEmpty() ? null : Collections.max(nemNullDatumok);
        return max;
    }

    public static Date min(Date datum1, Date datum2) {
        if (datum1 == null) {
            return datum2;
        }

        if (datum2 == null) {
            return datum1;
        }

        return datum2.after(datum1) ? datum1 : datum2;
    }

    public static String timeDiffHourMinSec(Date start, Date end) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(start);
        long startTime = calendar.getTimeInMillis();
        calendar.setTime(end);
        long endTime = calendar.getTimeInMillis();
        long diff = endTime - startTime;
        long seconds = (diff / 1000) % 60;
        long minutes = (diff / (60 * 1000)) % 60;
        long hours = diff / (60 * 60 * 1000);
        if (seconds < 0 || minutes < 0 || hours < 0) {
            return "";
        }
        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Az elso parameterben szereplo idoegysegtol kezdve lefele kerekit.
     *
     * @param calendarField
     * Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND,Calendar.MILLISECOND
     * @param date
     * @return
     */
    public static Date getCuttedDate(int calendarField, Date date) {
        if (calendarField < Calendar.HOUR || calendarField > Calendar.MILLISECOND) {
            throw new IllegalArgumentException("Nem megfelelő calendarField!");
        }
        if (date == null) {
            return date;
        }

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        for (int field = calendarField; field <= Calendar.MILLISECOND; field++) {
            calendar.set(field, 0);
        }
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return startOfDay(calendar.getTime());
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return startOfDay(calendar.getTime());
    }
}
