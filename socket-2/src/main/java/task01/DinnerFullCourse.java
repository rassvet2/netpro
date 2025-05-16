package task01;

public class DinnerFullCourse {
    private Dish dishes[];

	public static void main(String[] args) {
		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

	public DinnerFullCourse() {
		var soup = new Dish();
		soup.setName("スープ");
		soup.setValue(20);

		var salad = new Dish();
		salad.setName("特選シーザサラダ");
		salad.setValue(10);

		var rice = new Dish();
		rice.setName("銀しゃり");
		rice.setValue(2);

		var steak = new Dish();
		steak.setName("ステーキ");
		steak.setValue(30);

		var dessert = new Dish();
		dessert.setName("モンブラン");
		dessert.setValue(10);

		this.dishes = new Dish[] { soup, salad, rice, steak, dessert };
	}

	public void eatAll() {
		var sb = new StringBuilder();
		for (Dish dish : this.dishes) {
			sb.append(dish.getName());
			sb.append(" = ");
			sb.append(dish.getValue());
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		System.out.println("たかしへ、ママです。今日の晩御飯は" + sb.toString() + "よ");
	}
}
