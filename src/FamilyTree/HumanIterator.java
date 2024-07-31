package FamilyTree;
import Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int countIndex;
    private List<Human> familyTree;

    public HumanIterator(List<Human> familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > countIndex;
    }

    @Override
    public Human next() {
        return familyTree.get(countIndex++);
    }
}
