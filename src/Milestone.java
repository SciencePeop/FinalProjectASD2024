import java.util.*;

public class Milestone {
    private String name;
    private String type;
    private Map<Milestone, Integer> connectedMilestones;
    private String description;
    private int coinReward;
    private int energyRestored;


    //name (nama Milestone), coinReward(coin yang didapatkan di SideQuest), energyRestored(energy yang didapatkan di SideQuest), type(apakah ini start, sideQuest, mainQuest, atau Final)

    //Constructor untuk Start dan Main Quest
    public Milestone(String name, String type){
        this.name = name;
        this.type = type;
        this.connectedMilestones = new HashMap<>();
    }

    //Constructor untuk Side Quest
    public Milestone(String name, int coinReward, int energyRestored){
        this.name = name;
        this.type = "Side Quest";
        this.connectedMilestones = new HashMap<>();
        this.coinReward = coinReward;
        this.energyRestored = energyRestored;
    }

    //Constructor untuk Final Stage
    public Milestone(String name){
        this.name = name;
        this.type = "Final";
    }

    public void setDescription(String description){this.description = description;}

    public void addConnection(Milestone name, Integer cost){connectedMilestones.put(name, cost);}

    public Map<Milestone, Integer> getConnectedMilestones() {return connectedMilestones;}

    public Set<Milestone> getConnectedKeys() {return connectedMilestones.keySet();}

    public String getName(){return this.name;}

    public int getCoinReward() {return coinReward;}

    public int getEnergyRestored() {return energyRestored;}

    public int getEnergyCosts(Milestone selectedMilestone){
        if (connectedMilestones.containsKey(selectedMilestone)) {
            return connectedMilestones.get(selectedMilestone);
        } else {
            return 0;
        }
    }

    @Override
    public String toString(){return "Milestone{" + "name='" + name + '\'' + '}';}
}
