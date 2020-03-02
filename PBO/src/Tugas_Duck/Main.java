package Tugas_Duck;

import Tugas_Duck.Attack.*;
import Tugas_Duck.Defend.*;
import Tugas_Duck.Fly.*;
import Tugas_Duck.Sound.*;

public class Main {
    AttackBehaviour attackBehaviour;
    DefendBehaviour defendBehaviour;
    FlyBehaviour flyBehaviour;
    SoundBehaviour soundBehaviour;

    public Main(AttackBehaviour attackBehaviour, DefendBehaviour defendBehaviour, FlyBehaviour flyBehaviour, SoundBehaviour soundBehaviour){
        this.attackBehaviour = attackBehaviour;
        this.defendBehaviour = defendBehaviour;
        this.flyBehaviour = flyBehaviour;
        this.soundBehaviour = soundBehaviour;
    }

    public void getAttackBehaviour() {
        attackBehaviour.Attack();
    }

    public void getDefendBehaviour() {
        defendBehaviour.Defend();
    }

    public void getFlyBehaviour() {
        flyBehaviour.Fly();
    }

    public void getSoundBehaviour() {
        soundBehaviour.Sound();
    }

    public static void main(String[] args) {
        Main super_duck = new Main(new ArrowAttack(), new ShieldDefend(), new RocketFly(), new ToaSound());
        Main noob = new Main(new SwordAttack(), new ArmorDefend(), new WingsFly(), new NormalSound());
        Main change = new Main(new ArrowAttack(), new ShieldDefend(), new PlaneFly(), new ToaSound());

        System.out.println("Super Duck Behaviour : ");
        super_duck.getFlyBehaviour();
        super_duck.getSoundBehaviour();
        super_duck.getAttackBehaviour();
        super_duck.getDefendBehaviour();

        System.out.println("\nNoob Duck Behaviour : ");
        noob.getFlyBehaviour();
        noob.getSoundBehaviour();
        noob.getAttackBehaviour();
        noob.getDefendBehaviour();

        System.out.println("\nSuper Duck Change Fly Behaviour : ");
        change.getFlyBehaviour();
        change.getSoundBehaviour();
        change.getAttackBehaviour();
        change.getDefendBehaviour();
    }
}
