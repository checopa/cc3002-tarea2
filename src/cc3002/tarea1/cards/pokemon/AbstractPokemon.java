package cc3002.tarea1.cards.pokemon;


import cc3002.tarea1.cards.AbstractCard;
import cc3002.tarea1.cards.pokemon.fighting.AbstractFightingPokemon;
import cc3002.tarea1.cards.pokemon.fire.AbstractFirePokemon;
import cc3002.tarea1.cards.pokemon.grass.AbstractGrassPokemon;
import cc3002.tarea1.cards.pokemon.lighting.AbstractLightingPokemon;
import cc3002.tarea1.cards.pokemon.psychic.AbstractPsychicPokemon;
import cc3002.tarea1.cards.pokemon.water.AbstractWaterPokemon;
import cc3002.tarea1.habilities.Attack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author José Pacheco
 */
public abstract class AbstractPokemon extends AbstractCard implements IPokemon{
    private String name;
    private int id;
    private int hp;
    private List<Attack> attackList;
    private Attack selectedAttack;
    private Map<String, Integer> countEnergies = new HashMap<>();


    /**
     * Abstract class that represents a generic pokemon.
     * @param id pokemon's id
     * @param hp pokemon's hp
     * @param attackList pokemon's attack
     */
    protected AbstractPokemon(String name, int id, int hp, ArrayList<Attack> attackList) {
        super(name);
        this.id = id;
        this.hp = hp;
        this.attackList=attackList;
        if (4<this.attackList.size()){
            for (int i=0;i<this.attackList.size()-4;i++){
                this.attackList.remove(4);
            }
        }
        countEnergies.put("Water", 0);
        countEnergies.put("Grass", 0);
        countEnergies.put("Fire", 0);
        countEnergies.put("Fighting", 0);
        countEnergies.put("Psychic", 0);
        countEnergies.put("Lighting", 0);
    }
        //region Properties

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getHP() {
        return this.hp;
    }


    @Override
    public boolean isAlive() {
        return this.hp>0;
    }
    //endregion

    //region Attacks
    @Override
    public List<Attack> getAbilities() {
        return this.attackList;
    }

    @Override
    public Attack getSelectedAbility() {
        return this.selectedAttack;
    }

    @Override
    public void selectAbility(int index) {
        selectedAttack = attackList.get(index);

    }

    @Override
    public abstract void attack(IPokemon pokemon);

    @Override
    public void receiveWaterAttack(AbstractWaterPokemon attack) {
        this.receiveAttack(attack);
    }

    @Override
    public void receiveGrassAttack(AbstractGrassPokemon attack) {
        this.receiveAttack(attack);

    }

    @Override
    public void receiveFireAttack(AbstractFirePokemon attack) {
        this.receiveAttack(attack);
    }

    @Override
    public void receiveLightingAttack(AbstractLightingPokemon attack) {
        this.receiveAttack(attack);
    }

    @Override
    public void receiveFightingAttack(AbstractFightingPokemon attack) {
        this.receiveAttack(attack);
    }

    @Override
    public void receivePsychicAttack(AbstractPsychicPokemon attack) {
        this.receiveAttack(attack);
    }

    /**
     * Receive an attack
     *
     * @param attack Received attack
     */
    protected void receiveAttack(IPokemon attack) {
        this.hp -= attack.getSelectedAbility().getBaseDamage();
        if(!isAlive()){
            this.hp=0;
        }
    }

    /**
     * Receives an attack to which this Pokémon is weak.
     *
     * @param attack Received attack.
     */
    protected void receiveWeaknessAttack(IPokemon attack) {
        this.hp -= attack.getSelectedAbility().getBaseDamage() * 2;
        if(!isAlive()){
            this.hp=0;
        }
    }

    /**
     * Receives an attack to which this Pokémon is resistant.
     *
     * @param attack Received attack
     */
    public void receiveResistantAttack(IPokemon attack) {
        int hit=attack.getSelectedAbility().getBaseDamage()-30;
        if(hit>0){
            this.hp-=hit;
        }
        if(!isAlive()){
            this.hp=0;
        }
    }

    @Override
    public boolean cantAttack() {
        return getSelectedAbility().getFightingCost() <= getFightingEnergy() && getSelectedAbility().getFireCost() <= getFireEnergy()
                && getSelectedAbility().getGrassCost() <= getGrassEnergy() && getSelectedAbility().getPsychicCost() <= getPsychicEnergy()
                && getSelectedAbility().getLightingCost() <= getLightingEnergy() && getSelectedAbility().getWaterCost() <= getWaterEnergy();
    }
//endregion

    //region Energy
    @Override
    public void receiveLightingEnergy() {
        countEnergies.put("Lighting", this.getLightingEnergy() + 1);
    }

    @Override
    public void receiveFightingEnergy() {
        countEnergies.put("Fighting", this.getFightingEnergy() + 1);
    }

    @Override
    public void receiveFireEnergy() {
        countEnergies.put("Fire", this.getFireEnergy() + 1);
    }

    @Override
    public void receiveGrassEnergy() {
        countEnergies.put("Grass", this.getGrassEnergy() + 1);
    }

    @Override
    public void receivePsychicEnergy() {
        countEnergies.put("Psychic", this.getPsychicEnergy() + 1);
    }

    @Override
    public void receiveWaterEnergy() {
        countEnergies.put("Water", this.getWaterEnergy() + 1);
    }

    @Override
    public int getGrassEnergy() {
        return countEnergies.get("Grass");
    }

    @Override
    public int getFightingEnergy() {
        return countEnergies.get("Fighting");
    }

    @Override
    public int getFireEnergy() {
        return countEnergies.get("Fire");
    }

    @Override
    public int getWaterEnergy() {
        return countEnergies.get("Water");
    }

    @Override
    public int getPsychicEnergy() {
        return countEnergies.get("Psychic");
    }

    @Override
    public int getLightingEnergy() {
        return countEnergies.get("Lighting");
    }

    @Override
    public Map<String, Integer> getEnergies() {
        return countEnergies;
    }

    @Override
    public void setEnergies(Map<String, Integer> energies){
        this.countEnergies=energies;
    }

    //endregion

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IPokemon && ((IPokemon) obj).getId() == this.id
                && ((IPokemon) obj).getName().equals(name) && ((IPokemon) obj).getHP()==this.hp && ((IPokemon) obj).getAbilities().equals(this.attackList);
    }
}
