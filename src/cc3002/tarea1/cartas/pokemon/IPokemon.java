package cc3002.tarea1.cartas.pokemon;


import cc3002.tarea1.cartas.pokemon.lighting.LightingPokemon;
import cc3002.tarea1.cartas.pokemon.fighting.FightingPokemon;
import cc3002.tarea1.cartas.pokemon.fire.FirePokemon;
import cc3002.tarea1.cartas.pokemon.grass.GrassPokemon;
import cc3002.tarea1.cartas.pokemon.psychic.PsychicPokemon;
import cc3002.tarea1.cartas.pokemon.water.WaterPokemon;

import java.util.List;


/**
 *
 */
public interface IPokemon {
    /**
     * Getter for the pokemon's name.
     * @return Name of the pokemon
     */
    String getName();

    /**
     * Getter for the pokemon's hp
     * @return Hp of the pokemon
     */
    int getHP();

    /**
     * Getter for the pokemon's attacks
     * @return Attacks of the pokemon
     */
    List<Attack> getAttacks();

    /**
     * Getter for the attack selected
     * @return Attack selected
     */
    Attack getSelectedAttack();

    /**
     * Attack another pokemon
     * @param pokemon Target of the attack
     */
    void attack(IPokemon pokemon);

    /**
     * Selects an attack
     * @param index Index of the attack to be selected
     */
    void selectAttack(int index);

    /**
     * Receives damage from a water attack.
     *
     * @param attack Received attack.
     */
    void receiveWaterAttack(WaterPokemon attack);

    /**
     * Receives damage from a grass attack.
     *
     * @param attack Received attack.
     */
    void receiveGrassAttack(GrassPokemon attack);

    /**
     * Receives damage from a fire attack.
     *
     * @param attack Received attack.
     */
    void receiveFireAttack(FirePokemon attack);

    /**
     * Receives damage from a Lighting attack.
     *
     * @param attack Received attack.
     */
    void receiveLightingAttack(LightingPokemon attack);

    /**
     * Receives damage from a fight attack
     * @param attack Received attack.
     */
    void receiveFightingAttack(FightingPokemon attack);

    /**
     * Receives damage from a psychic attack
     * @param attack Received attack.
     */
    void receivePsychicAttack(PsychicPokemon attack);

    /**
     * Receive Lighting energy
     */
    void receiveLightingEnergy();

    /**
     * Receive fighting energy
     */
    void receiveFightingEnergy();

    /**
     * REceive fire energy
     */
    void receiveFireEnergy();

    /**
     * Receive grass energy
     */
    void receiveGrassEnergy();

    /**
     * Receive psychic energy
     */
    void receivePsychicEnergy();

    /**
     * REceive water energy
     */
    void receiveWaterEnergy();

    /**
     * returns the amount of Lighting energy
     * @return
     */
    int getLightingEnergy();

    /**
     * returns the amount of grass energy
     * @return
     */
    int getGrassEnergy();

    /**
     * returns the amount of fighting energy
     * @return
     */
    int getFightingEnergy();

    /**
     * returns the amount of fire energy
     * @return
     */
    int getFireEnergy();

    /**
     * returns the amount of water energy
     * @return
     */
    int getWaterEnergy();

    /**
     * returns the amount of psychic energy
     * @return
     */
    int getPsychicEnergy();

    /**
     * Return if the pokemon has enough energy to attack
     * @return
     */
    boolean cantAttack();


}