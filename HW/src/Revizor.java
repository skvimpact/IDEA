/**
 * Created by KSafonov on 07/09/2017.
 */
public class Revizor {
    private static String[] roles = {
        "Городничий",
        "Аммос Федорович",
        "Артемий Филиппович",
       //     "Лука",
        "Лука Лукич"};
    private static String[] textLines = {
        "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
//        "Артемий Филиппович: Вот не было заботы, так подай!",
            "Артемий Филиппович: Вот не было заботы Артемий Филиппович:, так подай!",
        "Лука Лукич: Господи боже! Лука Лукич: еще и с секретным предписаньем!"};
    public static void main(String[] args) {
        /*for (String i : roles) {
            System.out.println(i);
        }
        for (String i : textLines) {
            System.out.println(i);
        }*/
        System.out.println(printTextPerRole(roles, textLines));
    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        int index;

        for (int j = 0; j < roles.length; j++) {
            if (j > 0) sb.append("\n");
            sb.append(roles[j] + ":\n");

            for (int i = 0; i < textLines.length; i++) {
                index = textLines[i].indexOf(roles[j] + ":");
                if (index == 0) {
                    sb.append((i + 1) + ") " + textLines[i].substring((roles[j] + ":").length() + 1) + "\n");
                }
            }
        }
        return sb.toString();
    }
}
