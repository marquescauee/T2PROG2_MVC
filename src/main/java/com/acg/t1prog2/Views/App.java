/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views;

import com.acg.t1prog2.Controllers.Equipamento.CadastrarEquipamentoController;
import com.acg.t1prog2.Controllers.Equipamento.EditarEquipamentoController;
import com.acg.t1prog2.Controllers.Equipamento.ListarEquipamentoController;
import com.acg.t1prog2.Controllers.Equipamento.RemoverEquipamentoController;
import com.acg.t1prog2.Controllers.Esporte.RegrasSimulacaoController;
import com.acg.t1prog2.Controllers.Ginasio.AssociarEquipamentoController;
import com.acg.t1prog2.Controllers.Ginasio.BuscarEquipamentoController;
import com.acg.t1prog2.Controllers.Ginasio.CadastrarGinasioController;
import com.acg.t1prog2.Controllers.Ginasio.EditarGinasioController;
import com.acg.t1prog2.Controllers.Ginasio.ListarGinasioController;
import com.acg.t1prog2.Controllers.Ginasio.ListarReservasGinasioController;
import com.acg.t1prog2.Controllers.Ginasio.RemoverGinasioController;
import com.acg.t1prog2.Controllers.Ginasio.ReservarGinasioController;
import com.acg.t1prog2.Controllers.Pessoa.CadastrarPessoaController;
import com.acg.t1prog2.Controllers.Pessoa.CalcularMensalidadeAlunoController;
import com.acg.t1prog2.Controllers.Pessoa.CalcularSalarioProfessorController;
import com.acg.t1prog2.Controllers.Pessoa.EditarPessoaController;
import com.acg.t1prog2.Controllers.Pessoa.ListarPessoaController;
import com.acg.t1prog2.Controllers.Pessoa.RemoverPessoaController;
import com.acg.t1prog2.Controllers.Pessoa.TurmasAlunoController;
import com.acg.t1prog2.Controllers.Turma.CadastrarAlunoTurmaController;
import com.acg.t1prog2.Controllers.Turma.CadastrarTurmaController;
import com.acg.t1prog2.Controllers.Turma.EditarTurmaController;
import com.acg.t1prog2.Controllers.Turma.ListarTurmaController;
import com.acg.t1prog2.Controllers.Turma.RemoverTurmaController;
import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.DAO.EsporteDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.DAO.MensalidadeDAO;
import com.acg.t1prog2.DAO.ProfessorDAO;
import com.acg.t1prog2.DAO.ReservaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Tabela.EquipamentoTableModel;
import com.acg.t1prog2.Models.Tabela.GinasioTableModel;
import com.acg.t1prog2.Models.Tabela.PessoaTableModel;
import com.acg.t1prog2.Views.Equipamento.CadastrarEquipamentoView;
import com.acg.t1prog2.Views.Equipamento.EditarEquipamentoView;
import com.acg.t1prog2.Views.Equipamento.ListarEquipamentoView;
import com.acg.t1prog2.Views.Equipamento.RemoverEquipamentoView;
import com.acg.t1prog2.Views.Esporte.RegrasSimulacaoView;
import com.acg.t1prog2.Views.Ginasio.AssociarEquipamentoView;
import com.acg.t1prog2.Views.Ginasio.BuscarEquipamentoView;
import com.acg.t1prog2.Views.Ginasio.CadastrarGinasioView;
import com.acg.t1prog2.Views.Ginasio.EditarGinasioView;
import com.acg.t1prog2.Views.Ginasio.ListarGinasioView;
import com.acg.t1prog2.Views.Ginasio.ListarReservasGinasioView;
import com.acg.t1prog2.Views.Ginasio.RemoverGinasioView;
import com.acg.t1prog2.Views.Ginasio.ReservarGinasioView;
import com.acg.t1prog2.Views.Pessoa.CadastrarPessoaView;
import com.acg.t1prog2.Views.Pessoa.CalcularMensalidadeAlunoView;
import com.acg.t1prog2.Views.Pessoa.CalcularSalarioProfessorView;
import com.acg.t1prog2.Views.Pessoa.EditarPessoaView;
import com.acg.t1prog2.Views.Pessoa.ListarPessoaView;
import com.acg.t1prog2.Views.Pessoa.RemoverPessoaView;
import com.acg.t1prog2.Views.Pessoa.TurmasAlunoView;
import com.acg.t1prog2.Views.Turma.CadastrarAlunoTurmaView;
import com.acg.t1prog2.Views.Turma.CadastrarTurmaView;
import com.acg.t1prog2.Views.Turma.EditarTurmaView;
import com.acg.t1prog2.Views.Turma.ListarTurmaView;
import com.acg.t1prog2.Views.Turma.RemoverTurmaView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App extends javax.swing.JFrame {    
    
    public App() {
        initComponents();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpApp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mbInicial = new javax.swing.JMenuBar();
        mnSelecionarInicial = new javax.swing.JMenu();
        mnGinasios = new javax.swing.JMenu();
        mnCadastrarGinasio = new javax.swing.JMenuItem();
        mnListarGinasio = new javax.swing.JMenuItem();
        mnEditarGinasio = new javax.swing.JMenuItem();
        mnRemoverGinasio = new javax.swing.JMenuItem();
        mnAssociarEquipamento = new javax.swing.JMenuItem();
        mnBuscarEquipamento = new javax.swing.JMenuItem();
        mnReserva = new javax.swing.JMenu();
        miReservarGinasio = new javax.swing.JMenuItem();
        miListarReserva = new javax.swing.JMenuItem();
        mnEquipamentos = new javax.swing.JMenu();
        mnCadastrarEquipamentos = new javax.swing.JMenuItem();
        mnListarEquipamentos = new javax.swing.JMenuItem();
        mnEditarEquipamentos = new javax.swing.JMenuItem();
        mnRemoverEquipamentos = new javax.swing.JMenuItem();
        mnPessoas = new javax.swing.JMenu();
        miCadastrarPessoa = new javax.swing.JMenuItem();
        miListarPessoas = new javax.swing.JMenuItem();
        miEditarPessoa = new javax.swing.JMenuItem();
        miRemoverPessoa = new javax.swing.JMenuItem();
        mnCalculos = new javax.swing.JMenu();
        miAluno = new javax.swing.JMenuItem();
        miProfessor = new javax.swing.JMenuItem();
        miTurmasAluno = new javax.swing.JMenuItem();
        mnTurma = new javax.swing.JMenu();
        mnCadastrarTurma = new javax.swing.JMenuItem();
        mnListarTurma = new javax.swing.JMenuItem();
        mnEditarTurma = new javax.swing.JMenuItem();
        mnRemoverTurma = new javax.swing.JMenuItem();
        miCadastrarAluno = new javax.swing.JMenuItem();
        mnEsportes = new javax.swing.JMenu();
        miRegrasSimular = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setName("TelaInicial"); // NOI18N

        jpApp.setAlignmentX(0.0F);
        jpApp.setAlignmentY(0.0F);
        jpApp.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jpApp.setMinimumSize(new java.awt.Dimension(723, 396));

        String userName = System.getProperty("user.name");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Usu??rio: " + userName);

        LocalDate currentdate = LocalDate.now();
        String dia;
        String mes;

        if  (currentdate.getDayOfMonth() < 10)
        dia = ("0" + Integer.toString(currentdate.getDayOfMonth()));
        else
        dia = Integer.toString(currentdate.getDayOfMonth());

        if (currentdate.getMonthValue() < 10)
        mes = ("0" + Integer.toString(currentdate.getMonthValue()));
        else
        mes = Integer.toString(currentdate.getMonthValue());
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Data: " + dia + "/" + mes + "/" + currentdate.getYear());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        javax.swing.GroupLayout jpAppLayout = new javax.swing.GroupLayout(jpApp);
        jpApp.setLayout(jpAppLayout);
        jpAppLayout.setHorizontalGroup(
            jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAppLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAppLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jpAppLayout.setVerticalGroup(
            jpAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAppLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2))
        );

        mnSelecionarInicial.setText("Selecionar");
        mnSelecionarInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnGinasios.setText("Gin??sios");

        mnCadastrarGinasio.setText("Cadastrar");
        mnCadastrarGinasio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnCadastrarGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrarGinasioActionPerformed(evt);
            }
        });
        mnGinasios.add(mnCadastrarGinasio);

        mnListarGinasio.setText("Listar");
        mnListarGinasio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnListarGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListarGinasioActionPerformed(evt);
            }
        });
        mnGinasios.add(mnListarGinasio);

        mnEditarGinasio.setText("Editar");
        mnEditarGinasio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnEditarGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarGinasioActionPerformed(evt);
            }
        });
        mnGinasios.add(mnEditarGinasio);

        mnRemoverGinasio.setText("Remover");
        mnRemoverGinasio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnRemoverGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemoverGinasioActionPerformed(evt);
            }
        });
        mnGinasios.add(mnRemoverGinasio);

        mnAssociarEquipamento.setText("Associar Equipamento");
        mnAssociarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAssociarEquipamentoActionPerformed(evt);
            }
        });
        mnGinasios.add(mnAssociarEquipamento);

        mnBuscarEquipamento.setText("Buscar Equipamento");
        mnBuscarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBuscarEquipamentoActionPerformed(evt);
            }
        });
        mnGinasios.add(mnBuscarEquipamento);

        mnSelecionarInicial.add(mnGinasios);

        mnReserva.setText("Reservas");

        miReservarGinasio.setText("Reservar Gin??sio");
        miReservarGinasio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miReservarGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarGinasio(evt);
            }
        });
        mnReserva.add(miReservarGinasio);

        miListarReserva.setText("Listar Reservas");
        miListarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miListarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarReservas(evt);
            }
        });
        mnReserva.add(miListarReserva);

        mnSelecionarInicial.add(mnReserva);

        mnEquipamentos.setText("Equipamentos");

        mnCadastrarEquipamentos.setText("Cadastrar");
        mnCadastrarEquipamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnCadastrarEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrarEquipamentosActionPerformed(evt);
            }
        });
        mnEquipamentos.add(mnCadastrarEquipamentos);

        mnListarEquipamentos.setText("Listar");
        mnListarEquipamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnListarEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListarEquipamentosActionPerformed(evt);
            }
        });
        mnEquipamentos.add(mnListarEquipamentos);

        mnEditarEquipamentos.setText("Editar");
        mnEditarEquipamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnEditarEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarEquipamentosActionPerformed(evt);
            }
        });
        mnEquipamentos.add(mnEditarEquipamentos);

        mnRemoverEquipamentos.setText("Remover");
        mnRemoverEquipamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnRemoverEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemoverEquipamentosActionPerformed(evt);
            }
        });
        mnEquipamentos.add(mnRemoverEquipamentos);

        mnSelecionarInicial.add(mnEquipamentos);

        mnPessoas.setText("Pessoas");
        mnPessoas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        miCadastrarPessoa.setText("Cadastrar");
        miCadastrarPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miCadastrarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastrarPessoaActionPerformed(evt);
            }
        });
        mnPessoas.add(miCadastrarPessoa);

        miListarPessoas.setText("Listar");
        miListarPessoas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miListarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListarPessoasActionPerformed(evt);
            }
        });
        mnPessoas.add(miListarPessoas);

        miEditarPessoa.setText("Editar");
        miEditarPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miEditarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditarPessoaActionPerformed(evt);
            }
        });
        mnPessoas.add(miEditarPessoa);

        miRemoverPessoa.setText("Remover");
        miRemoverPessoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miRemoverPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoverPessoaActionPerformed(evt);
            }
        });
        mnPessoas.add(miRemoverPessoa);

        mnCalculos.setText("Calcular");

        miAluno.setText("Mensalidade Aluno");
        miAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAlunoActionPerformed(evt);
            }
        });
        mnCalculos.add(miAluno);

        miProfessor.setText("Sal??rio Professor");
        miProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miProfessorActionPerformed(evt);
            }
        });
        mnCalculos.add(miProfessor);

        mnPessoas.add(mnCalculos);

        miTurmasAluno.setText("Turmas do Aluno");
        miTurmasAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miTurmasAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTurmasAlunoActionPerformed(evt);
            }
        });
        mnPessoas.add(miTurmasAluno);

        mnSelecionarInicial.add(mnPessoas);

        mnTurma.setText("Turmas");
        mnTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mnCadastrarTurma.setText("Cadastrar");
        mnCadastrarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrarTurmaActionPerformed(evt);
            }
        });
        mnTurma.add(mnCadastrarTurma);

        mnListarTurma.setText("Listar");
        mnListarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnListarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnListarTurmaActionPerformed(evt);
            }
        });
        mnTurma.add(mnListarTurma);

        mnEditarTurma.setText("Editar");
        mnEditarTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnEditarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEditarTurmaActionPerformed(evt);
            }
        });
        mnTurma.add(mnEditarTurma);

        mnRemoverTurma.setText("Remover");
        mnRemoverTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnRemoverTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRemoverTurmaActionPerformed(evt);
            }
        });
        mnTurma.add(mnRemoverTurma);

        miCadastrarAluno.setText("Cadastrar Aluno");
        miCadastrarAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastrarAlunoActionPerformed(evt);
            }
        });
        mnTurma.add(miCadastrarAluno);

        mnSelecionarInicial.add(mnTurma);

        mnEsportes.setText("Esportes");
        mnEsportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        miRegrasSimular.setText("Regras e Simula????o");
        miRegrasSimular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miRegrasSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRegrasSimulacao(evt);
            }
        });
        mnEsportes.add(miRegrasSimular);

        mnSelecionarInicial.add(mnEsportes);

        mbInicial.add(mnSelecionarInicial);

        setJMenuBar(mbInicial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadastrarGinasioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrarGinasioActionPerformed
        CadastrarGinasioController  cgc = new CadastrarGinasioController(new CadastrarGinasioView());
        cgc.exibirTela();
    }//GEN-LAST:event_mnCadastrarGinasioActionPerformed

    private void mnListarGinasioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListarGinasioActionPerformed
        ListarGinasioController lgc = new ListarGinasioController(new ListarGinasioView(), new GinasioTableModel(GinasioDAO.recuperarTodosGinasios()));
        lgc.exibir();
    }//GEN-LAST:event_mnListarGinasioActionPerformed

    private void mnEditarGinasioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarGinasioActionPerformed
        EditarGinasioController egc = new EditarGinasioController(new EditarGinasioView());
        egc.exibirTela();
    }//GEN-LAST:event_mnEditarGinasioActionPerformed

    private void mnRemoverGinasioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemoverGinasioActionPerformed
        RemoverGinasioController rgc = new RemoverGinasioController(new RemoverGinasioView());
        rgc.exibirTela();
    }//GEN-LAST:event_mnRemoverGinasioActionPerformed


    private void mnCadastrarEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrarEquipamentosActionPerformed
        CadastrarEquipamentoController cec = new CadastrarEquipamentoController(new CadastrarEquipamentoView());
        
        cec.exibirTela();
    }//GEN-LAST:event_mnCadastrarEquipamentosActionPerformed

    private void mnListarEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListarEquipamentosActionPerformed
        List<Equipamento> equips = EquipamentoDAO.recuperarTodosEquipamentos();
        
        Collections.sort(equips);
        
        List<Equipamento> listaOrdenada = new ArrayList<>();
        
        for(Equipamento equip : equips) {
            listaOrdenada.add(equip);
        }
        
        ListarEquipamentoController lec = new ListarEquipamentoController(new ListarEquipamentoView(), new EquipamentoTableModel(listaOrdenada));
        lec.exibir();
    }//GEN-LAST:event_mnListarEquipamentosActionPerformed

    private void mnEditarEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarEquipamentosActionPerformed
        EditarEquipamentoController eec = new EditarEquipamentoController(new EditarEquipamentoView());
        eec.exibirTela();
    }//GEN-LAST:event_mnEditarEquipamentosActionPerformed

    private void mnRemoverEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemoverEquipamentosActionPerformed
        RemoverEquipamentoController rec = new RemoverEquipamentoController(new RemoverEquipamentoView());
        rec.exibirTela();
    }//GEN-LAST:event_mnRemoverEquipamentosActionPerformed

    private void mnCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrarTurmaActionPerformed
        CadastrarTurmaController ctc = new CadastrarTurmaController(new CadastrarTurmaView());
        ctc.exibirTela();
    }//GEN-LAST:event_mnCadastrarTurmaActionPerformed

    private void mnListarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnListarTurmaActionPerformed
        ListarTurmaController ltc = new ListarTurmaController(new ListarTurmaView());
        ltc.exibirTela();
    }//GEN-LAST:event_mnListarTurmaActionPerformed

    private void mnEditarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEditarTurmaActionPerformed
        EditarTurmaController etc = new EditarTurmaController(new EditarTurmaView());
        etc.exibirTela();
    }//GEN-LAST:event_mnEditarTurmaActionPerformed

    private void mnRemoverTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRemoverTurmaActionPerformed
        RemoverTurmaController rtc = new RemoverTurmaController(new RemoverTurmaView());
        rtc.exibirTela();
    }//GEN-LAST:event_mnRemoverTurmaActionPerformed

    private void miCadastrarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastrarPessoaActionPerformed
        CadastrarPessoaController cpc = new CadastrarPessoaController(new CadastrarPessoaView());
        cpc.exibirTela();
    }//GEN-LAST:event_miCadastrarPessoaActionPerformed

    private void miListarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListarPessoasActionPerformed
        List<Pessoa> pessoas = new ArrayList<>();

        for(Aluno a : AlunoDAO.recuperarTodosAlunos()) {
            pessoas.add(a);
        }
        
        for(Professor p : ProfessorDAO.recuperarTodosProfessores()) {
            pessoas.add(p);
        }
        
        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        
        ListarPessoaController lpc = new ListarPessoaController(new ListarPessoaView(), new PessoaTableModel(pessoas));
        lpc.exibirTela();
    }//GEN-LAST:event_miListarPessoasActionPerformed

    private void miEditarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditarPessoaActionPerformed
        EditarPessoaController epc = new EditarPessoaController(new EditarPessoaView());
        epc.exibirTela();
    }//GEN-LAST:event_miEditarPessoaActionPerformed

    private void miRemoverPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoverPessoaActionPerformed
        RemoverPessoaController rpc = new RemoverPessoaController(new RemoverPessoaView());
        rpc.exibirTela();
    }//GEN-LAST:event_miRemoverPessoaActionPerformed


    private void miCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastrarAlunoActionPerformed
        CadastrarAlunoTurmaController catc = new CadastrarAlunoTurmaController(new CadastrarAlunoTurmaView());
        catc.exibirTela();
    }//GEN-LAST:event_miCadastrarAlunoActionPerformed

    private void miAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAlunoActionPerformed
        CalcularMensalidadeAlunoController cmac = new CalcularMensalidadeAlunoController(new CalcularMensalidadeAlunoView());
        cmac.exibirTela();
    }//GEN-LAST:event_miAlunoActionPerformed

    private void miProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miProfessorActionPerformed
        CalcularSalarioProfessorController cspc = new CalcularSalarioProfessorController(new CalcularSalarioProfessorView());
        cspc.exibirTela();
    }//GEN-LAST:event_miProfessorActionPerformed

    private void miTurmasAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTurmasAlunoActionPerformed
        TurmasAlunoController tac = new TurmasAlunoController(new TurmasAlunoView());
        tac.exibirTela();
    }//GEN-LAST:event_miTurmasAlunoActionPerformed

    private void reservarGinasio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarGinasio
        ReservarGinasioController rgc = new ReservarGinasioController(new ReservarGinasioView());
        rgc.exibirTela();
    }//GEN-LAST:event_reservarGinasio

    private void listarReservas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarReservas
        ListarReservasGinasioController lrgc = new ListarReservasGinasioController(new ListarReservasGinasioView());
        lrgc.exibirTela();
    }//GEN-LAST:event_listarReservas

    private void mostrarRegrasSimulacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarRegrasSimulacao
        RegrasSimulacaoController rsc = new RegrasSimulacaoController(new RegrasSimulacaoView());
        rsc.exibirTela();
    }//GEN-LAST:event_mostrarRegrasSimulacao

    private void mnAssociarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAssociarEquipamentoActionPerformed
        AssociarEquipamentoController aec = new AssociarEquipamentoController(new AssociarEquipamentoView());
        
        aec.exibirTela();
    }//GEN-LAST:event_mnAssociarEquipamentoActionPerformed

    private void mnBuscarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBuscarEquipamentoActionPerformed
        BuscarEquipamentoController bec = new BuscarEquipamentoController(new BuscarEquipamentoView());
        
        bec.exibirTela();
    }//GEN-LAST:event_mnBuscarEquipamentoActionPerformed
 
    //In??cio M??todo Main
    public static void main(String args[]) {
        App app = new App();    
        
        AlunoDAO.createTable();
        EquipamentoDAO.createTable();
        EsporteDAO.createTable();
        GinasioDAO.createTable();
        LanceDAO.createTable();
        MensalidadeDAO.createTable();
        ProfessorDAO.createTable();
        ReservaDAO.createTable();
        TurmaDAO.createTable();
        
        app.setVisible(true);
    }
    //Fim M??todo Main


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpApp;
    private javax.swing.JMenuBar mbInicial;
    private javax.swing.JMenuItem miAluno;
    private javax.swing.JMenuItem miCadastrarAluno;
    private javax.swing.JMenuItem miCadastrarPessoa;
    private javax.swing.JMenuItem miEditarPessoa;
    private javax.swing.JMenuItem miListarPessoas;
    private javax.swing.JMenuItem miListarReserva;
    private javax.swing.JMenuItem miProfessor;
    private javax.swing.JMenuItem miRegrasSimular;
    private javax.swing.JMenuItem miRemoverPessoa;
    private javax.swing.JMenuItem miReservarGinasio;
    private javax.swing.JMenuItem miTurmasAluno;
    private javax.swing.JMenuItem mnAssociarEquipamento;
    private javax.swing.JMenuItem mnBuscarEquipamento;
    private javax.swing.JMenuItem mnCadastrarEquipamentos;
    private javax.swing.JMenuItem mnCadastrarGinasio;
    private javax.swing.JMenuItem mnCadastrarTurma;
    private javax.swing.JMenu mnCalculos;
    private javax.swing.JMenuItem mnEditarEquipamentos;
    private javax.swing.JMenuItem mnEditarGinasio;
    private javax.swing.JMenuItem mnEditarTurma;
    private javax.swing.JMenu mnEquipamentos;
    private javax.swing.JMenu mnEsportes;
    private javax.swing.JMenu mnGinasios;
    private javax.swing.JMenuItem mnListarEquipamentos;
    private javax.swing.JMenuItem mnListarGinasio;
    private javax.swing.JMenuItem mnListarTurma;
    private javax.swing.JMenu mnPessoas;
    private javax.swing.JMenuItem mnRemoverEquipamentos;
    private javax.swing.JMenuItem mnRemoverGinasio;
    private javax.swing.JMenuItem mnRemoverTurma;
    private javax.swing.JMenu mnReserva;
    private javax.swing.JMenu mnSelecionarInicial;
    private javax.swing.JMenu mnTurma;
    // End of variables declaration//GEN-END:variables
}
