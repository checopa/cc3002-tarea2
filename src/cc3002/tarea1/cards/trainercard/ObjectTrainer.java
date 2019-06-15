package cc3002.tarea1.cards.trainercard;

import cc3002.tarea1.effects.IEffect;
import cc3002.tarea1.visitor.Visitor;

public class ObjectTrainer extends AbstractTrainerCard {


    protected ObjectTrainer(String name, String description, IEffect effect) {
        super(name, description, effect);
    }

    @Override
    public void accept(Visitor v) {
        v.visitObjectCard(this);
    }
}
