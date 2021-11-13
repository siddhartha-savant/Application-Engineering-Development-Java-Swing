/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.City;
import Model.Community;
import Model.House;
import Model.Person;
import Model.PersonDirectory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;
import javax.swing.JFileChooser;
import java.util.*; 

/**
 *
 * @author siddharthasavant
 */
public class CreateJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateJPanel
     */
    
    private JPanel rightPane;
    private PersonDirectory personDirectory;
    public static Map<String, House> houseMap;
    public static Map<String, Community> communityMap;
    public static Map<String, City> cityMap;
        
    public CreateJPanel(JPanel rightPane, PersonDirectory personDirectory) {
        initComponents();
        this.rightPane = rightPane;
        this.personDirectory = personDirectory;
        this.houseMap = new HashMap<>();
        this.communityMap = new HashMap<>();
        this.cityMap = new HashMap<>();
    }
    
    private void readFromCSV(String fileName) {
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Person person = createPerson(attributes);
                if(person == null){
                    return;
                }
                personDirectory.addPerson(person);
                line = br.readLine();
            }
            
            JOptionPane.showMessageDialog(null, "CSV successfully uploaded");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private Person createPerson(String[] metadata) {
        try{
            String firstName = metadata[0];
            String lastName = metadata[1];
            String gender = metadata[2];
            int age = Integer.parseInt(metadata[3]);
            String address1 = metadata[4];
            String address2 = metadata[5];
            String cityName = metadata[6];
            
        
            if(firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()
                || address1.isEmpty() || address2.isEmpty() || cityName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Entered Emptied Data. Please try again");
                return null;
            }
            
            Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setGender(gender);
        person.setAge(age);
        if(cityMap.containsKey(cityName)){
            City city = cityMap.get(cityName);
            Community community = communityMap.get(address2);
            if(city.getCommunitySet().contains(community)){
                House house = houseMap.get(address1);  
                if(community.getHouseSet().contains(house)){
                    house.addPerson(person);      
                    person.setHouse(house);
                }else{
                    House houseNew = new House(address1);
                    community.addHouse(houseNew);
                    houseNew.setCommunity(community);
                    houseNew.addPerson(person);
                    person.setHouse(houseNew);
                    houseMap.put(address1, houseNew);
                }
            }else{
                Community communityNew = new Community(address2);
                city.addCommunity(communityNew);
                House house = new House(address1);
                communityNew.setCity(city);
                communityNew.addHouse(house);
                house.setCommunity(communityNew);
                house.addPerson(person);
                person.setHouse(house);
                communityMap.put(address2, communityNew);
                houseMap.put(address1, house);
            }
        }else{
            City city = new City(cityName);
            Community community = new Community(address2);
            city.addCommunity(community);
            House house = new House(address1);
            community.setCity(city);
            community.addHouse(house);
            house.setCommunity(community);
            house.addPerson(person);
            person.setHouse(house);
            cityMap.put(cityName, city);
            communityMap.put(address2, community);
            houseMap.put(address1, house);
        }
            
//            System.out.println(personDirectory.toString());
//            Person person = new Person();
//            person.setFirstName(firstName);
//            person.setLastName(lastName);
//            person.setGender(gender);
//            person.setAge(age);
//            if(houseMap.containsKey(address1)){
//                House house = houseMap.get(address1);
//                house.addPerson(person);
//                person.setHouse(house);
//            }else{
//                System.out.println("New House created");
//                House house = new House(address1);
//                System.out.println(house.getAddress() + " This is address");
//                house.addPerson(person);
//                System.out.println(house.getPersonList().get(0).getFirstName() + " First person added name");
//                System.out.println(house.getCommunity() + " This is null");
//                person.setHouse(house);
//                houseMap.put(address1, house);
//            }
//            
//            if(communityMap.containsKey(address2)){
//                Community community = communityMap.get(address2);
//                community.addHouse(person.getHouse());
//            }else{
//                System.out.println("New Community created");
//                Community community = new Community(address2);
//                System.out.println(community.getCommunityName() + " This is community address");
//                community.addHouse(person.getHouse());
//                person.getHouse().setCommunity(community);
//                System.out.println(person.getHouse().getCommunity().getCommunityName() + " This should not be null");
//                communityMap.put(address2, community);
//            }
//            
//            if(cityMap.containsKey(cityName)){
//                City city = cityMap.get(cityName);
//                city.addCommunity(person.getHouse().getCommunity());          
//            }else{
//                City city = new City(cityName);
//                city.addCommunity(person.getHouse().getCommunity());
//                person.getHouse().getCommunity().setCity(city);
//                cityMap.put(cityName, city);
//            }
            
            return person;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Enter Correct Data and try again");
            return null;
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupMC = new javax.swing.ButtonGroup();
        buttonGroupA = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAddressLine1 = new javax.swing.JLabel();
        txtAddressLine1 = new javax.swing.JTextField();
        lblAddressLine2 = new javax.swing.JLabel();
        txtAddressLine2 = new javax.swing.JTextField();
        btnPerson = new javax.swing.JButton();
        txtCityName = new javax.swing.JTextField();
        lblCityName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAddCSV = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(128, 209, 223));

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Luminari", 1, 35)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(10, 48, 58));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Beth Israel Deaconess Medical Center");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblFirstName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(10, 48, 58));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("First Name:");

        txtFirstName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyReleased(evt);
            }
        });

        lblLastName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(10, 48, 58));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Last Name:");

        txtLastName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLastNameKeyReleased(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblGender.setForeground(new java.awt.Color(10, 48, 58));
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGender.setText("Gender:");

        txtGender.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });
        txtGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGenderKeyReleased(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblAge.setForeground(new java.awt.Color(10, 48, 58));
        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAge.setText("Age:");

        txtAge.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgeKeyReleased(evt);
            }
        });

        lblAddressLine1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblAddressLine1.setForeground(new java.awt.Color(10, 48, 58));
        lblAddressLine1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressLine1.setText("Address Line 1:");

        txtAddressLine1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtAddressLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressLine1ActionPerformed(evt);
            }
        });
        txtAddressLine1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressLine1KeyReleased(evt);
            }
        });

        lblAddressLine2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblAddressLine2.setForeground(new java.awt.Color(10, 48, 58));
        lblAddressLine2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressLine2.setText("Address Line 2:");

        txtAddressLine2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtAddressLine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressLine2ActionPerformed(evt);
            }
        });
        txtAddressLine2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressLine2KeyReleased(evt);
            }
        });

        btnPerson.setBackground(new java.awt.Color(255, 255, 255));
        btnPerson.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        btnPerson.setForeground(new java.awt.Color(251, 131, 106));
        btnPerson.setText("Create Person");
        btnPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonActionPerformed(evt);
            }
        });

        txtCityName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtCityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityNameActionPerformed(evt);
            }
        });
        txtCityName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCityNameKeyReleased(evt);
            }
        });

        lblCityName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblCityName.setForeground(new java.awt.Color(10, 48, 58));
        lblCityName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCityName.setText("City Name:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText(" ");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel2KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText(" ");
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel3KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(" ");
        jLabel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel4KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText(" ");
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel5KeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText(" ");
        jLabel6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel6KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText(" ");
        jLabel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel7KeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText(" ");

        btnAddCSV.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCSV.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        btnAddCSV.setForeground(new java.awt.Color(251, 131, 106));
        btnAddCSV.setText("ADD CSV");
        btnAddCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCSVActionPerformed(evt);
            }
        });

        lblTitle1.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(10, 48, 58));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Address: 330 Brookline Ave, Boston, MA 02215  Phone: (617) 667-7000");

        lblTitle2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle2.setFont(new java.awt.Font("Lucida Grande", 3, 30)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(10, 48, 58));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Enter Person Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(btnAddCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(btnPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(338, 338, 338)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGender)
                                    .addComponent(lblLastName)
                                    .addComponent(lblAge)
                                    .addComponent(lblAddressLine1)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblAddressLine2)
                                    .addComponent(lblCityName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAddressLine2)
                                            .addComponent(txtAddressLine1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(132, 132, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(lblTitle2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle1)
                .addGap(58, 58, 58)
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblAddressLine1, lblAddressLine2, lblAge, lblCityName, lblFirstName, lblGender, lblLastName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAddressLine1, txtAddressLine2, txtAge, txtCityName, txtFirstName, txtGender, txtLastName});

    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenderActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtAddressLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressLine1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressLine1ActionPerformed

    private void txtAddressLine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressLine2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressLine2ActionPerformed

    private void btnPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonActionPerformed
        // TODO add your handling code here:
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String gender = txtGender.getText();
        
        int age;
        try{
            age = Integer.parseInt(txtAge.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: Enter Correct Age");
            return;
        }
        String address1 = txtAddressLine1.getText();
        String address2 = txtAddressLine2.getText();
        String cityName = txtCityName.getText();
        
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setGender(gender);
        person.setAge(age);
        if(cityMap.containsKey(cityName)){
            City city = cityMap.get(cityName);
            Community community = communityMap.get(address2);
            if(city.getCommunitySet().contains(community)){
                House house = houseMap.get(address1);  
                if(community.getHouseSet().contains(house)){
                    house.addPerson(person);      
                    person.setHouse(house);
                }else{
                    House houseNew = new House(address1);
                    community.addHouse(houseNew);
                    houseNew.setCommunity(community);
                    houseNew.addPerson(person);
                    person.setHouse(houseNew);
                    houseMap.put(address1, houseNew);
                }
            }else{
                Community communityNew = new Community(address2);
                city.addCommunity(communityNew);
                House house = new House(address1);
                communityNew.setCity(city);
                communityNew.addHouse(house);
                house.setCommunity(communityNew);
                house.addPerson(person);
                person.setHouse(house);
                communityMap.put(address2, communityNew);
                houseMap.put(address1, house);
            }
        }else{
            City city = new City(cityName);
            Community community = new Community(address2);
            city.addCommunity(community);
            House house = new House(address1);
            community.setCity(city);
            community.addHouse(house);
            house.setCommunity(community);
            house.addPerson(person);
            person.setHouse(house);
            cityMap.put(cityName, city);
            communityMap.put(address2, community);
            houseMap.put(address1, house);
        }
        
        
//        if(houseMap.containsKey(address1)){
//            House house = houseMap.get(address1);
//            house.addPerson(person);
//            person.setHouse(house);
//        }else{
//            System.out.println("New House created");
//            House house = new House(address1);
//            System.out.println(house.getAddress() + " This is address");
//            house.addPerson(person);
//            System.out.println(house.getPersonList().get(0).getFirstName() + " First person added name");
//            System.out.println(house.getCommunity() + " This is null");
//            person.setHouse(house);
//            houseMap.put(address1, house);
//        }
//
//        if(communityMap.containsKey(address2)){
//            Community community = communityMap.get(address2);
//            community.addHouse(person.getHouse());
//        }else{
//            System.out.println("New Community created");
//            Community community = new Community(address2);
//            System.out.println(community.getCommunityName() + " This is community address");
//            community.addHouse(person.getHouse());
//            person.getHouse().setCommunity(community);
//            System.out.println(person.getHouse().getCommunity().getCommunityName() + " This should not be null");
//            communityMap.put(address2, community);
//        }
//
//        if(cityMap.containsKey(cityName)){
//            City city = cityMap.get(cityName);
//            city.addCommunity(person.getHouse().getCommunity());          
//        }else{
//            City city = new City(cityName);
//            city.addCommunity(person.getHouse().getCommunity());
//            person.getHouse().getCommunity().setCity(city);
//            cityMap.put(cityName, city);
//        }
        
        if(txtFirstName.getText().isEmpty() || txtGender.getText().isEmpty() || txtLastName.getText().isEmpty()
                || txtAge.getText().isEmpty() || txtAddressLine1.getText().isEmpty() || txtAddressLine2.getText().isEmpty() || txtCityName.getText().isEmpty()
                || jLabel2.getText()!=null || jLabel3.getText()!=null  || jLabel4.getText()!=null || jLabel5.getText()!=null 
                || jLabel6.getText()!=null  || jLabel7.getText()!=null  || jLabel8.getText()!=null ){
            JOptionPane.showMessageDialog(null, "Entered Empty Data. Please try again");
            return;
        }
        
        personDirectory.addPerson(person);
        JOptionPane.showMessageDialog(null, "Person Details Sucessfully Created");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtGender.setText("");
        txtAge.setText("");
        txtAddressLine1.setText("");
        txtAddressLine2.setText("");
        txtCityName.setText("");
    }//GEN-LAST:event_btnPersonActionPerformed

    private void txtCityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityNameActionPerformed

    private void jLabel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyReleased
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jLabel2KeyReleased

    private void jLabel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jLabel3KeyReleased

    private void jLabel4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel4KeyReleased
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jLabel4KeyReleased

    private void jLabel5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel5KeyReleased

    private void jLabel6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel6KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel6KeyReleased

    private void jLabel7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel7KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel7KeyReleased

    private void txtFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z]{0,30}$");
        Matcher match = pattern.matcher(txtFirstName.getText());
        boolean matchFound = match.matches();
        if(!matchFound){
            jLabel2.setText("Enter valid input data");
        }else{
            jLabel2.setText(null);
        }
    }//GEN-LAST:event_txtFirstNameKeyReleased

    private void txtLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z]{0,30}$");
        Matcher match = pattern.matcher(txtLastName.getText());
        boolean matchFound = match.matches();
        if(!matchFound){
            jLabel3.setText("Enter valid input data");
        }else{
            jLabel3.setText(null);
        }
    }//GEN-LAST:event_txtLastNameKeyReleased

    private void txtGenderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGenderKeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z]{0,30}$");
        Matcher match = pattern.matcher(txtGender.getText());
        boolean matchFound = match.find();
        if(!matchFound){
            jLabel4.setText("Enter valid input data");
        }else{
            jLabel4.setText(null);
        }
    }//GEN-LAST:event_txtGenderKeyReleased

    private void txtAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[1-9]{1,2}$");
        Matcher match = pattern.matcher(txtAge.getText());
        boolean matchFound = match.find();
        if(!matchFound){
            jLabel5.setText("Enter valid input data");
        }else{
            jLabel5.setText(null);
        }
    }//GEN-LAST:event_txtAgeKeyReleased

    private void txtAddressLine1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressLine1KeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z0-9 ]{0,30}$");
        Matcher match = pattern.matcher(txtAddressLine1.getText());
        boolean matchFound = match.find();
        if(!matchFound){
            jLabel6.setText("Enter valid input data");
        }else{
            jLabel6.setText(null);
        }
    }//GEN-LAST:event_txtAddressLine1KeyReleased

    private void txtAddressLine2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressLine2KeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z ]{0,30}$");
        Matcher match = pattern.matcher(txtAddressLine2.getText());
        boolean matchFound = match.find();
        if(!matchFound){
            jLabel7.setText("Enter valid input data");
        }else{
            jLabel7.setText(null);
        }
    }//GEN-LAST:event_txtAddressLine2KeyReleased

    private void txtCityNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityNameKeyReleased
        // TODO add your handling code here:
        Pattern pattern = Pattern.compile("^[a-zA-z ]{0,30}$");
        Matcher match = pattern.matcher(txtCityName.getText());
        boolean matchFound = match.find();
        if(!matchFound){
            jLabel8.setText("Enter valid input data");
        }else{
            jLabel8.setText(null);
        }
    }//GEN-LAST:event_txtCityNameKeyReleased

    private void btnAddCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCSVActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        int returnVal = jFileChooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            readFromCSV(jFileChooser.getSelectedFile().getAbsolutePath());
            //JOptionPane.showMessageDialog(null, "CSV successfully uploaded");
        }
    }//GEN-LAST:event_btnAddCSVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCSV;
    private javax.swing.JButton btnPerson;
    private javax.swing.ButtonGroup buttonGroupA;
    private javax.swing.ButtonGroup buttonGroupMC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAddressLine1;
    private javax.swing.JLabel lblAddressLine2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCityName;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTextField txtAddressLine1;
    private javax.swing.JTextField txtAddressLine2;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables
}
