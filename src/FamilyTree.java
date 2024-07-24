import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTree = new ArrayList<>();
    private static long id = 0;

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;}
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            addToParent(human);
            addToChildren(human);
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        int id = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : familyTree) {
            id++;
            stringBuilder.append(id + ". ");
            if (human.getLastName() != null) {
                stringBuilder.append("Фамилия: " + human.getLastName() + "; ");
            } else {
                stringBuilder.append("Фамилия: неизвестна; ");
            }
            if (human.getFirstname() != null) {
                stringBuilder.append("Имя: " + human.getFirstname() + "; ");
            } else {
                stringBuilder.append("Имя: неизвестно; ");
            }
            if (human.getPatronymic() != null) {
                stringBuilder.append("Отчество: " + human.getPatronymic() + "; ");
            } else {
                stringBuilder.append("Отчество: неизвестно; ");
            }
            if (human.getGender() != null) {
                stringBuilder.append("Пол: " + human.getGender() + "; ");
            } else {
                stringBuilder.append("Пол: не указан; ");
            }
            if (human.getDayBirth() != null) {
                stringBuilder.append("Возраст(лет):" + human.getAge(human.getDayBirth(), human.getDayDeath()) + "; ");
            } else {
                stringBuilder.append("Возраст: не известен;");
            }
            if (human.getFather() != null) {
                stringBuilder.append("Отец: " + human.getFIO(human.getFather()) + "; ");
            } else {
                stringBuilder.append("Отец: не указан; ");
            }
            if (human.getMother() != null) {
                stringBuilder.append("Мать: " + human.getFIO(human.getMother()) + "; ");
            } else {
                stringBuilder.append("Мать: не указана; ");
            }
            if (human.getChildren().size() != 0) {
                stringBuilder.append("Дети: " + human.getChildren(human.getChildren()) + "; ");
            } else {
                stringBuilder.append("Дети: не указаны; ");
            }
            if (human.getPlaceBorn() != null) {
                stringBuilder.append("Место рождения: " + human.getPlaceBorn() + "; ");
            } else {
                stringBuilder.append("Место рождения: не указано;");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    private void addToParent(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }


}



