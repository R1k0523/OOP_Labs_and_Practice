package rtu.klokov.labs.lab16;

public enum DrinkTypeEnum {
    BEER,
    WINE,
    VODKA,
    BRANDY,
    CHAMPANGE,
    WHISKEY,
    TEQUILA,
    RUM,
    VERMUTH,
    LIQUOR,
    JAGERMEISTER,
    JUICE,
    COFFEE,
    GREEN_TEA,
    BLACK_TEA,
    MILK,
    WATER,
    SODA;

    static {
        BEER.value = new Drink(70, "Пиво", "Пиво – древнейший алкогольный напиток, известный человечеству.", 0.05, BEER);
        WINE.value = new Drink(120, "Вино", "Вино какой страны предпочитаете в это время дня?", 0.05, BEER);
        VODKA.value = new Drink(110, "Водка", "Основные составляющие водки — это вода и спирт. ", 0.4, VODKA);
        BRANDY.value = new Drink(340, "Бренди", "В переводе с английского 'Пережженое вино'.Бренди производят из виноградного вина.", 0.4, BRANDY);
        CHAMPANGE.value = new Drink(280, "Шампанское", "Изготавливается он из виноградного сока, который путем натурального брожения газируется.", 0.1, CHAMPANGE);
        WHISKEY.value = new Drink(410, "Виски", "Нет тех, кто не любит виски, есть те, кто не нашел свой сорт.", 0.6, WHISKEY);
        TEQUILA.value = new Drink(370, "Текила", "Крепкий алкогольный напиток из сока агавы", 0.5, TEQUILA);
        RUM.value = new Drink(200, "Ром", "Ром - это ведь не просто напиток, это скорее друг, с которым вам всегда легко.", 0.4, RUM);
        VERMUTH.value = new Drink(170, "Вермут", "Полынное вино, аперитив на основе вина", 0.15, VERMUTH);
        LIQUOR.value = new Drink(350, "Ликер", "Состав ликера в секрете. Известно лишь, что в нем содержится невероятное количество различных трав.", 0.4, LIQUOR);
        JAGERMEISTER.value = new Drink(220, "Егермейстер", "Немецкий крепкий ликёр, настоянный на травах. ", 0.35, JAGERMEISTER);
        JUICE.value = new Drink(70, "Сок", "Фруктовые соки питательны и полезны.", 0, JUICE);
        COFFEE.value = new Drink(60, "Кофе", "Три кружки чёрного кофе — и вот я уже почти человек.", 0, COFFEE);
        GREEN_TEA.value = new Drink(40, "Зеленый чай", "Согласно легенде, чай открыт китайским героем почти за 3000 тысячи лет до нашей эры.", 0, GREEN_TEA);
        BLACK_TEA.value = new Drink(35, "Черный чай", "Черный чай согревает душу", 0, BLACK_TEA);
        MILK.value = new Drink(62, "Молоко", "Молоко — это изумительная пища, приготовленная самой природой.", 0, MILK);
        WATER.value = new Drink(10, "Вода", "Шишкин лес", 0, WATER);
        SODA.value = new Drink(45, "Содовая", "Газированная вода со вкусом любимого мороженого. ", 0, SODA);
    }

    private Drink value;

    public Drink getValue() {
        return value;
    }
}
