package com.example.data

import com.example.model.*

object StalkieCasesData {

    val allCases: List<CaseDefinition> = listOf(

        CaseDefinition(
            id = 1,
            theme = "TRAIÇÃO AMOROSA",
            title = "O Quarto Vazio",
            clientName = "Carla (32, Médica)",
            targetName = "Diego",
            clientBriefingMessages = listOf(
                "Oi, detetive. Esse é o celular antigo do meu marido, o Diego.",
                "Ele é representante de vendas e viaja muito. Ultimamente, ele tem chegado exausto, frio, e a desculpa é sempre o excesso de trabalho.",
                "Eu amo o Diego, temos uma história de 10 anos, mas ontem vi uma notificação estranha antes de ele trocar de aparelho.",
                "Preciso saber se ele está com outra pessoa nas viagens. Por favor, me ajude!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "porsche",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 78,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "🚗 Porsche Macan Preto", "Foto de um carro desportivo (Porsche)", isFavorite = true, vectorResType = "porsche"),
                    GalleryPhoto(2, "🍕 Jantar Solo", "Pizza em Curitiba"),
                    GalleryPhoto(3, "🛏️ Chalé das Montanhas", "Vista para o vale verde"),
                    GalleryPhoto(4, "👩 Priscila sorrindo no passageiro", "Priscila no banco do pendura", isDeleted = true, vectorResType = "selfie")
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Mecânico (Oficina Central)",
                        lastMessage = "Vinho Tinto",
                        lastTime = "Amanhã",
                        isArchived = true,
                        messages = listOf(
                            ChatMessage("Diego", "Oi, tudo certo pro chalé?", "13:40", isMe = true),
                            ChatMessage("Mecânico", "Sim, já peguei as chaves.", "13:42"),
                            ChatMessage("Diego", "Ótimo. O que quer jantar de noite lá?", "13:45", isMe = true),
                            ChatMessage("Mecânico", "Vinho Tinto", "13:46")
                        )
                    ),
                    WhatsAppChat(
                        contactName = "Carla Amor",
                        lastMessage = "Estou na palestra financeira agora, amor, exausto.",
                        lastTime = "13:30",
                        messages = listOf(
                            ChatMessage("Carla Amor", "Como estão as coisas na convenção amor?", "13:00"),
                            ChatMessage("Diego", "Estou na palestra financeira agora, amor, exausto.", "13:30", isMe = true)
                        )
                    )
                ),
                walletTransactions = listOf(
                    WalletTransaction("Restaurante 'La Table'", "R$ 480,00", "Amanhã - 13:00"),
                    WalletTransaction("Posto Shell Curitiba", "R$ 220,00", "Ontem"),
                    WalletTransaction("Airbnb Estada", "R$ 1.500,00", "Ontem")
                ),
                paypalNotifications = listOf("Transferência efetuada com sucesso: R$ 3.500,00 para Joias Diamond"),
                paypalBalance = "R$ 3.500,00",
                gmailInboxes = listOf(
                    GmailMessage(
                        "Joias Diamond",
                        "Recibo de Compra - Colar Ouro 18k",
                        "Obrigado pela sua compra. Colar de Ouro 18k enviado.",
                        "Ontem",
                        "Prezado Diego, segue em anexo o comprovante da compra do Colar de Ouro 18k no valor de R$ 3.500,00."
                    ),
                    GmailMessage(
                        "Convenção de Vendas 2026",
                        "Confirmação de Inscrição",
                        "Bem-vindo à Convenção em Curitiba.",
                        "Anteontem",
                        "Sua participação no evento do dia 28 está confirmada no centro de convenções de Curitiba."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Amigos", "Lucas (Irmão) - Nascido em 1992. Mãe - Nascida em 1968."),
                    NoteEntry(2, "Plano Secreto 🔐", "Buscar chaves do apartamento alugado no Centro para a Pri", isLocked = true, pinCode = "1992")
                ),
                matches = listOf(
                    HingeProfile(
                        "Priscila",
                        27,
                        "Vivendo intensamente. Adoro vinhos e carros velozes.",
                        "Selfie sorrindo",
                        chatHistory = listOf(
                            ChatMessage("Diego", "Oi linda, te vi no Hinge. Vamos nos encontrar na viagem?", "Segunda", isMe = true),
                            ChatMessage("Priscila", "Claro! Vamos no Chalé das Montanhas.", "Segunda")
                        )
                    )
                ),
                mapPins = listOf(
                    MapPinDefinition("Trabalho 2", "Rua das Flores, 120", "-25.429, -49.271", "Apartamento de Curitiba"),
                    MapPinDefinition("Convenção", "Av. Paulista, 1500", "-23.561, -46.655", "Sede SP")
                ),
                geminiQueries = listOf(
                    GeminiQuery("Como excluir rastro de fotos no Android", "Você pode excluir e depois esvaziar a lixeira no app Galeria.", "Ontem")
                )
            ),
            steps = listOf(
                CaseStep(1, "Qual é a imagem de fundo do ecrã (wallpaper) do Diego?", "Espreite o app Fotos ou verifique o padrão do plano de fundo.", "Foto de um carro desportivo (Porsche)", listOf("Foto de um carro desportivo (Porsche)", "Foto romântica de casal", "Foto do cachorro Jack", "Fundo abstrato azul"), "Dica: É um carro super esportivo de cor preta."),
                CaseStep(2, "Qual foi a última compra faturada no Apple Pay?", "Abra o Apple Pay/Wallet e vá ao histórico.", "Restaurante 'La Table'", listOf("Posto Shell", "Restaurante 'La Table'", "Airbnb Estada", "Uber Trip"), "Dica: Um jantar sofisticado com francês no nome."),
                CaseStep(3, "No Calendário, para que cidade é marcada a 'Convenção de Vendas'?", "Consulte os compromissos agendados no Calendário.", "Curitiba", listOf("Rio de Janeiro", "Curitiba", "São Paulo", "Porto Alegre"), "Dica: Fica no sul do país."),
                CaseStep(4, "O voo dele atrasou hoje? Procura algum e-mail da companhia aérea no Gmail.", "Abra o Gmail e procure confirmação de voo.", "Não há e-mails de voo (ele não viajou de avião)", listOf("Sim, atrasou 2h", "Não há e-mails de voo (ele não viajou de avião)", "Sim, o voo foi cancelado", "Sim, de Curitiba para SP"), "Dica: Ele viajou de carro (Porsche), por isso não há voos."),
                CaseStep(5, "Ele usa o ano de nascimento do irmão como código para as Notas. Que ano é esse?", "Procure por Lucas nos Contactos/Calendário ou notas livres.", "1992", listOf("1988", "1990", "1992", "1995"), "Dica: Em notas soltas ou procurando o irmão Lucas."),
                CaseStep(6, "Onde Diego conheceu a mulher com quem está se encontrando?", "Verifique aplicativos de namoro instalados na gaveta do telefone.", "Hinge", listOf("Hinge", "Tinder", "Happn", "Instagram"), "Dica: Encontre o aplicativo Hinge escondido em uma pasta."),
                CaseStep(7, "Qual é o nome do 'Match' recente dele no Hinge?", "Abra o Hinge e veja a conversa recente.", "Priscila", listOf("Fernanda", "Priscila", "Carol", "Vitória"), "Dica: Nome começa com P."),
                CaseStep(8, "No WhatsApp, sob que nome ele salvou o contacto dela para esconder as conversas?", "Procure pelas conversas arquivadas no WhatsApp.", "Mecânico (Oficina Central)", listOf("Chefe Marcelo", "Mecânico (Oficina Central)", "Primo Rodrigo", "Suporte Tim"), "Dica: Um trocadilho com consertos de carro."),
                CaseStep(9, "No chat do WhatsApp com esse contato, qual bebida ela pede para o encontro?", "Abra a conversa arquivada de 'Mecânico'.", "Vinho Tinto", listOf("Cerveja", "Vinho Tinto", "Gin", "Champanhe"), "Dica: Clássico jantar romântico pede um tinto."),
                CaseStep(10, "No Airbnb, qual é o nome do local reservado?", "Abra o app Airbnb e confira a viagem ativa.", "Chalé das Montanhas", listOf("Chalé das Montanhas", "Hotel Centro", "Apartamento Praia", "Pousada Verde"), "Dica: Fica na montanha."),
                CaseStep(11, "Quantos dias dura essa luxuosa reserva no Airbnb?", "Veja os detalhes de check-in e check-out da reserva.", "3 dias", listOf("1 dia", "2 dias", "3 dias", "5 dias"), "Dica: São 3 diárias reservadas."),
                CaseStep(12, "No app Câmara/Lixeira, qual é o assunto da foto apagada?", "Vá ao Fotos -> Álbum -> Lixeira / Excluídas.", "Priscila no banco do pendura", listOf("Quarto bagunçado", "Priscila no banco do pendura", "Carro riscado", "Nota de compra"), "Dica: Ela está sentada no banco do carona (pendura) do Porsche."),
                CaseStep(13, "No Google Maps, qual endereço ele salvou como 'Trabalho 2'?", "Abra o Maps e veja os locais rotulados ou salvos.", "Rua das Flores, 120", listOf("Av. Paulista, 1500", "Rua das Flores, 120", "Rua das Palmeiras, 45", "Rua XV de Novembro, 10"), "Dica: Fica na Rua das Flores."),
                CaseStep(14, "Ele comprou um presente caro para a amante. O recibo está no Gmail. O que foi?", "Estude os e-mails recentes de compras no Gmail.", "Colar de Ouro 18k", listOf("Anel de Diamante", "Colar de Ouro 18k", "Bolsa de Luxo", "Brincos de Esmeralda"), "Dica: Joia de pescoço, de ouro puro."),
                CaseStep(15, "Qual foi o valor exato pago via Mercado Pago por essa joia?", "Verifique o extrato do Mercado Pago.", "R$ 3.500,00", listOf("R$ 1.500,00", "R$ 2.800,00", "R$ 3.500,00", "R$ 4.800,00"), "Dica: Três mil e quinhentos reais."),
                CaseStep(16, "No app Relógio, o que diz a anotação do alarme das 15h?", "Confira a lista de Alarmes configurados no app Relógio.", "Ligar à Carla e fingir que estou na palestra", listOf("Ligar à Carla e fingir que estou na palestra", "Almoço de Negócios", "Saída Airbnb", "Comprar Vinho"), "Dica: Um lembrete para mentir para a esposa."),
                CaseStep(17, "Use o PIN (ano do irmão) para desbloquear a nota secreta. Qual é o PIN?", "Insira o código correto de 4 dígitos no bloco de Notas bloqueado.", "1992", listOf("1988", "1992", "2016", "4099"), "Dica: É o ano do Lucas que você descobriu no passo 5."),
                CaseStep(18, "O que diz a nota protegida que estava trancada?", "Abra a nota secreta após digitar o PIN.", "Buscar chaves do apartamento alugado no Centro para a Pri", listOf("Comprar passagem Suíça", "Buscar chaves do apartamento alugado no Centro para a Pri", "Senha da conta", "Mentiras para Carla"), "Dica: Menciona pegar as chaves no Centro para a Pri."),
                CaseStep(19, "Vá ao app Scanner. Qual o título do contrato assinado recentemente?", "Verifique os PDFs digitalizados recentemente no app Scanner.", "Contrato de Arrendamento como fiador", listOf("Contrato de Arrendamento como fiador", "Cessão de Direitos", "Venda de Automóvel", "Contrato de Prestação de Serviços"), "Dica: Ele assinou como fiador para a amante."),
                CaseStep(20, "Fase 3: Escolha as provas fundamentais para enviar para a Carla nas Mensagens.", "Selecione a reserva do Airbnb, o extrato do Mercado Pago e o contrato do Scanner e envie.", "Enviar provas (Airbnb + Mercado Pago + Scanner)", listOf("Enviar provas (Airbnb + Mercado Pago + Scanner)", "Enviar só a foto excluída", "Enviar localização de Trabalho 2", "Marcar um encontro direto"), "Dica: Selecione a combinação letal de provas no bate-papo com Carla para finalizar!")
            )
        ),

        CaseDefinition(
            id = 2,
            theme = "TRAIÇÃO FINANCEIRA",
            title = "Sociedade Falida",
            clientName = "Beto (28, Empreendedor)",
            targetName = "Marcos",
            clientBriefingMessages = listOf(
                "Detetive, peguei o celular da firma que ficava com meu sócio, o Marcos.",
                "Nossa startup de tecnologia está quebrando, o dinheiro sumiu misteriosamente.",
                "O Marcos jura que os investidores recuaram por causa da crise econômica, mas eu não engulo essa desculpa.",
                "Nós crescemos juntos no bairro, ele era como um irmão! Ache as provas de onde foi parar o nosso capital."
            ),
            phoneData = CasePhoneData(
                wallpaperType = "sunset",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 90,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "📉 Gráficos de Queda", "Print financeiro editado"),
                    GalleryPhoto(2, "🎰 Print Secreto da Calculadora", "Um print de ameaça de morte por dívida de jogo", isDeleted = true, requiresPin = true)
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Beto Sócio",
                        lastMessage = "R$ 15,40",
                        lastTime = "Ontem",
                        messages = listOf(
                            ChatMessage("Beto Sócio", "Cara, quanto sobrou na conta do banco da firma?", "10:00"),
                            ChatMessage("Marcos", "Quase nada, só sobrou R$ 15,40", "10:05", isMe = true)
                        )
                    ),
                    WhatsAppChat(
                        contactName = "Tio Patinhas",
                        lastMessage = "Vou te apagar se não pagar amanhã.",
                        lastTime = "12:00",
                        messages = listOf(
                            ChatMessage("Tio Patinhas", "Cadê os 120 mil do cassino?", "Ontem"),
                            ChatMessage("Tio Patinhas", "Vou te apagar se não pagar amanhã.", "12:00")
                        )
                    )
                ),
                walletTransactions = listOf(
                    WalletTransaction("Casino Royal Bet", "R$ 120.000,00", "Segunda"),
                    WalletTransaction("InnovaTech S/A", "R$ 50.000,00", "Ontem")
                ),
                paypalNotifications = listOf("Transferência retida por suspeita de fraude"),
                paypalBalance = "R$ 15,42",
                linkedinInMailChats = listOf(
                    WhatsAppChat(
                        contactName = "InnovaTech Recrutador",
                        lastMessage = "Cargo de Diretor de TI",
                        lastTime = "Ontem",
                        messages = listOf(
                            ChatMessage("InnovaTech Recrutador", "Sua proposta de venda do software foi aceita.", "Ontem"),
                            ChatMessage("InnovaTech Recrutador", "Vamos oferecer o Cargo de Diretor de TI com bônus.", "Ontem")
                        )
                    )
                ),
                linkedinProfileStatus = "Em busca de oportunidades com rivais",
                healthSteps = 14000,
                gmailInboxes = listOf(
                    GmailMessage(
                        "Dra. Sônia Investimentos",
                        "Reserva suspensa",
                        "Investimento cancelado.",
                        "Ontem",
                        "Prezado Marcos, devido à falta de garantias da sua startup, a Dra. Sônia suspendeu o aporte."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Senhas do Cofre", "Use o recorde máximo do jogo 2048 para abrir a Calculadora secreta.")
                ),
                mapPins = listOf(
                    MapPinDefinition("Encontro Secreto", "Heliponto do Hotel Plaza", "-23.55, -46.63", "Encontro com InnovaTech")
                ),
                geminiQueries = listOf(
                    GeminiQuery("Como formatar servidores remotamente sem deixar rastos", "Você precisaria de privilégios de administrador do sistema e rodar um script destrutivo.", "Hoje")
                ),
                employeeCode = "8192"
            ),
            steps = listOf(
                CaseStep(1, "Qual é o nome da rede Wi-Fi conectada agora nas Configurações?", "Abra o aplicativo Configurações para conferir a rede conectada.", "Starbucks_Free", listOf("Starbucks_Free", "Office_Corporate", "Honeypot_Network", "Vivo_Fibra_92G"), "Dica: Fica em um café muito famoso."),
                CaseStep(2, "Qual foi o saldo final de firma que ele mandou em um print no WhatsApp para o Beto?", "Abra o chat com o sócio Beto no WhatsApp.", "R$ 15,40", listOf("R$ 15,40", "R$ 1.500,00", "R$ 80.000,00", "R$ 0,00"), "Dica: Um saldo ridiculamente baixo de quinze reais e quarenta centavos."),
                CaseStep(3, "Qual é o nome da investidora chave que não responde mais no LinkedIn dele?", "Abra o LinkedIn e confira o perfil ou mensagens.", "Dra. Sônia", listOf("Dra. Sônia", "Doutora Amanda", "Cristina Capital", "Camila Invest"), "Dica: Uma investidora com cargo médico 'Dra.'."),
                CaseStep(4, "Ele faltou ao trabalho alegando estar doente. Quantos passos ele deu ontem no app Saúde?", "Confira no app de Saúde/Forma os dados de atividade física de ontem.", "14.000 passos", listOf("140 passos", "1.200 passos", "14.000 passos", "5.000 passos"), "Dica: Quatorze mil passos de caminhada saudável."),
                CaseStep(5, "Há alguma notificação vermelha pendente no app PayPal das finanças corporativas?", "Abra o app PayPal e examine as notificações recentes.", "Transferência retida por suspeita de fraude", listOf("Transferência retida por suspeita de fraude", "Saldo atualizado", "Conta de energia atrasada", "Parceria cancelada"), "Dica: Um aviso crítico de crime fiscal."),
                CaseStep(6, "No Mercado Pago, o dinheiro saiu por PIX para qual destino suspeito?", "Abra do Mercado Pago/Wallet as transações de PIX.", "Casino Royal Bet", listOf("Casino Royal Bet", "Agiota Express", "InnovaTech S/A", "Beto Sócio"), "Dica: Um site de apostas e jogos de azar."),
                CaseStep(7, "Qual foi o valor acumulado da perda total dele nesse cassino online?", "Veja o montante da transação para o cassino no Mercado Pago.", "R$ 120.000,00", listOf("R$ 40.000,00", "R$ 120.000,00", "R$ 200.000,00", "R$ 15.400,00"), "Dica: Cento e vinte mil reais perdidos."),
                CaseStep(8, "Em qual aplicativo ele está negociando secretamente com a rival 'InnovaTech'?", "Procure em canais profissionais de comunicação como LinkedIn.", "LinkedIn", listOf("WhatsApp", "LinkedIn", "Telegram", "Gmail"), "Dica: É a maior rede de contatos profissionais."),
                CaseStep(9, "O que a InnovaTech ofereceu a Marcos em troca dos dados da empresa?", "Abra do LinkedIn as mensagens InMail da InnovaTech.", "Cargo de Diretor de TI", listOf("Suborno de R$ 500k", "Cargo de Diretor de TI", "Suporte Jurídico", "Férias na Europa"), "Dica: Uma posição de liderança tecnológica."),
                CaseStep(10, "Marcos tem instalado o jogo 2048. Qual é o seu atual recorde guardado?", "Vá no jogo 2048 se estiver no celular e verifique o High Score da tela de início.", "8192", listOf("1024", "2048", "4096", "8192"), "Dica: O dobro do card final de 4096."),
                CaseStep(11, "Abra a Calculadora, digite esse recorde do 2048 e aperte '='. O que acontece?", "Use o teclado da Calculadora para digitar o código de desbloqueio secreto.", "A Calculadora abre um Cofre Secreto", listOf("Dá erro de sintaxe", "A Calculadora abre um Cofre Secreto", "Mostra o resultado matemático", "Calculadora desliga"), "Dica: Digite 8192 e pressione '=' no app Calculadora."),
                CaseStep(12, "O que tem na primeira e única foto secreta guardada nesse cofre da calculadora?", "Inspeccione a galeria protegida secreta da calculadora.", "Um print de ameaça de morte por dívida de jogo", listOf("Os códigos fontes roubados", "Um print de ameaça de morte por dívida de jogo", "Uma foto com a amante", "Informações fiscais da startup"), "Dica: Print ameaçador do cobrador de dívidas."),
                CaseStep(13, "Qual é o nome ou apelido do perigoso agiota nas Mensagens (SMS)?", "Abra o Gmail ou Mensagens para ler o histórico de ameaças de cobrança.", "Tio Patinhas", listOf("Zeca Urubu", "Tio Patinhas", "Hacker Dark", "Rato Cego"), "Dica: Apelido de um pato riquíssimo dos desenhos animados."),
                CaseStep(14, "O que ele andou perguntando secretamente para a inteligência artificial no app Gemini?", "Confira o histórico de prompts de busca no app Gemini.", "Como formatar servidores remotamente sem deixar rastos", listOf("Como formatar servidores remotamente sem deixar rastos", "Melhores jogos de apostas", "Passagem barata para Miami", "Como fingir estar doente"), "Dica: Ele queria ocultar o rastro apagando os servidores da startup."),
                CaseStep(15, "No Calendário, o que está agendado e assustador para amanhã às 12h?", "Confira as tarefas programadas no Calendário corporativo.", "Prazo Final - Entregar chave do servidor", listOf("Prazo Final - Entregar chave do servidor", "Reunião de Conciliação startup", "Aniversário do Beto", "Pagamento de Cassino"), "Dica: Envolve repassar o controle total da infraestrutura."),
                CaseStep(16, "Ele recebeu um Pix adiantado ou depósito ilegal na carteira. De quanto foi o valor no Mercado Pago?", "Retorne às transações da carteira.", "R$ 50.000,00", listOf("R$ 10.000,00", "R$ 50.000,00", "R$ 120.000,00", "R$ 500.000,00"), "Dica: Metade de cem mil reais."),
                CaseStep(17, "Onde Marcos vai se encontrar com o comprador rival? Procure nos locais do Google Maps.", "Abra o Google Maps e examine os pins salvos para amanhã.", "Heliponto do Hotel Plaza", listOf("Sala de Reuniões AeroTech", "Heliponto do Hotel Plaza", "Terminal Metropolitano", "Starbucks Central"), "Dica: Local elevado e super exclusivo com direito a helicópteros."),
                CaseStep(18, "Qual aplicativo profissional de edição ele usou para faturar a falsa assinatura do Beto?", "Identifique o aplicativo de modificação visual instalado.", "Photoshop", listOf("Lightroom", "Photoshop", "Paint", "Canva"), "Dica: O editor profissional da gigante Adobe."),
                CaseStep(19, "O documento final fraudado está no app Scanner sob qual nome?", "Verifique a lixeira ou documentos do Scanner.", "Termo_de_Cessao_TechWave.pdf", listOf("Contrato_Firma_Assinado.pdf", "Termo_de_Cessao_TechWave.pdf", "Testamento_Ficticio.doc", "BaconIntel_Leaks.csv"), "Dica: É um Termo de Cessão."),
                CaseStep(20, "Fase 3: Selecione o material conclusivo e despache por e-mail para Beto desmascarar Marcos.", "Selecione as ameaças do agiota no SMS e o termo fraudado do Scanner e envie para o Beto via Gmail de Marcos.", "Envia as SMS do agiota e o PDF falso do Scanner para o e-mail de Beto através do Gmail de Marcos.", listOf("Envia as SMS do agiota e o PDF falso do Scanner para o e-mail de Beto através do Gmail de Marcos.", "Chamar a polícia civil diretamente no WhatsApp", "Formatador de discos", "Excluir conta do cassino"), "Dica: Envie o material probatório via Gmail corporativo de Marcos!")
            )
        ),

        CaseDefinition(
            id = 3,
            theme = "TRAIÇÃO FAMILIAR",
            title = "Sangue do Meu Sangue",
            clientName = "Teresa (50, Dona de Casa)",
            targetName = "Leandro",
            clientBriefingMessages = listOf(
                "Meu pai faleceu há um mês. Ele era muito rico, mas o testamento digital deixou tudo para o meu irmão caçula, o Leandro.",
                "Eu fui praticamente deserdada. Leandro jura que foi a última vontade expressa do papai, mas não faz sentido algum.",
                "Eu roubei o celular do Leandro durante o velório. Somos do mesmo sangue, mas ele sempre foi ganancioso e egoísta.",
                "Por favor, prove que ele manipulou ou falsificou de alguma forma o testamento do nosso pai!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "sunset",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 40,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "📋 Assinatura Falsificada", "Teste de assinatura do doutor"),
                    GalleryPhoto(2, "🚢 Dinheiro escondido na lancha", "Em sacos do lixo numa lancha em Angra", isDeleted = false, isFavorite = true),
                    GalleryPhoto(3, "📜 Testamento Papai", "Falso testemunho", isDeleted = true)
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Enfermeira Maria",
                        lastMessage = "Ameaçou denunciá-la por roubo de medicamentos.",
                        lastTime = "Segunda",
                        messages = listOf(
                            ChatMessage("Leandro", "Se você não assinar como testemunha do testamento, conto tudo.", "Segunda", isMe = true),
                            ChatMessage("Enfermeira Maria", "Isso é chantagem! Mas ok, eu assino Maria da Penha.", "Segunda")
                        )
                    )
                ),
                walletTransactions = listOf(
                    WalletTransaction("Loja de Barcos Angra", "R$ 25.000,00", "Ontem"),
                    WalletTransaction("Suborno Dr. Silveira", "R$ 250.000,00", "Ontem")
                ),
                gmailInboxes = listOf(
                    GmailMessage(
                        "Advogado Fraudes",
                        "Confirmação de Alteração",
                        "Enviamos o documento para o cartório.",
                        "Ontem",
                        "Prezado Leandro, o Dr. Silveira confirmou que a página 3 foi excluída e seu pai assinou a nova versão."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Dr. Silveira Particular", "Ou entregas o documento B, ou exponho a tua amante.")
                ),
                mapPins = listOf(
                    MapPinDefinition("Morte do Pai", "No cartório de plantão", "-23.00, -43.20", "Cartório onde estava Leandro à noite")
                ),
                geminiQueries = listOf(
                    GeminiQuery("Como reescrever PDF em editor photoshop sem deixar rastros digitais", "Use a ferramenta de carimbo para limpar metadados e manter camadas achatadas.", "Ontem")
                ),
                employeeCode = "0315"
            ),
            steps = listOf(
                CaseStep(1, "Qual foi a última música que ele ouviu no Spotify?", "Verifique a última reprodução de música no app Spotify.", "We Are The Champions", listOf("We Are The Champions", "Bohemian Rhapsody", "Sad Song No7", "Skyfall Theme"), "Dica: Hino vitorioso do Queen sobre ser campeão."),
                CaseStep(2, "Qual é a cidade favorita com clima atual no app de Meteorologia?", "Abra o aplicativo de Clima/Meteorologia.", "Angra dos Reis", listOf("Rio de Janeiro", "Angra dos Reis", "Búzios", "Paraty"), "Dica: Famosa baía fluminense procurada por milionários."),
                CaseStep(3, "Quantas chamadas perdidas da irmã (Teresa) há registradas no Telefone?", "Abra o histórico de ligações recentes no app Telefone.", "25", listOf("5", "12", "25", "50"), "Dica: Um número alto indicando o desespero e insistência de Teresa."),
                CaseStep(4, "O que ele postou de fingimento de luto no seu perfil do Instagram?", "Examine o último post no feed ou stories do Instagram do Leandro.", "Foto a chorar com \"Obrigado por tudo, velho\"", listOf("Foto a chorar com \"Obrigado por tudo, velho\"", "Fundo preto liso", "Citação religiosa", "Foto do túmulo do pai"), "Dica: Uma foto chorando com agradecimento ao 'velho' pai."),
                CaseStep(5, "Qual era o número da casa de Búzios do pai para decifrar a senha base do telefone?", "Descubra na agenda de contatos ou anotações de Búzios.", "44", listOf("12", "44", "88", "101"), "Dica: A senha total seria 'Buzios44', então o número da casa é:"),
                CaseStep(6, "Nas Notas, há um rascunho de bilhete de ameaça para o Dr. Silveira. O que ele diz?", "Verifique o rascunho de nota em rascunhos livres.", "Ou entregas o documento B, ou exponho a tua amante.", listOf("Quero metade da herança amanhã", "Ou entregas o documento B, ou exponho a tua amante.", "Preciso assinar o testamento urgentemente", "Obrigado pela consultoria judicial"), "Dica: Uma grave chantagem envolvendo expor o caso extraconjugal do advogado."),
                CaseStep(7, "Nas Configurações -> Bateria, qual aplicativo consumiu inacreditáveis 60% de energia?", "Abra a saúde e as estatísticas de consumo de bateria em Configurações.", "Photoshop", listOf("WhatsApp", "Instagram", "Photoshop", "Safari"), "Dica: Um forte sinal de falsificação gráfica."),
                CaseStep(8, "O que ele alterou no Photoshop?", "Consulte no histórico os arquivos ou indícios de edição do testamento.", "A página 3 do Testamento (apagando o nome da Teresa).", listOf("Assinatura do testamento legítimo", "A página 3 do Testamento (apagando o nome da Teresa).", "Valor total de depósitos bancários", "Data da certidão de óbito"), "Dica: Excluiu a página chave onde Teresa era beneficiada."),
                CaseStep(9, "No app Scanner, quem assinou como testemunha no PDF FALSO?", "Abra o Scanner de documentos e veja as assinaturas do arquivo editado.", "Maria da Penha", listOf("Maria da Penha", "Lucas Santos", "Dr. Nelson Silveira", "Teresa Silva"), "Dica: Primeiro nome é Maria."),
                CaseStep(10, "No WhatsApp, como ele convenceu e coagiu essa enfermeira de plantão a assinar a mentira?", "Leia os trechos finais de diálogo na conversa com a Enfermeira Maria no WhatsApp.", "Ameaçou denunciá-la por roubo de medicamentos.", listOf("Ofereceu suborno de R$ 50 mil", "Ameaçou denunciá-la por roubo de medicamentos.", "Disse ser filho legítimo", "Pagou as contas atrasadas dela"), "Dica: Envolve um suposto roubo de remédios do hospital do pai."),
                CaseStep(11, "O advogado subornado cobrou sua parte por SMS. Qual o valor que ele pediu em dinheiro?", "Procure pelas mensagens SMS informando a propina.", "R$ 250.000,00", listOf("R$ 50.000,00", "R$ 100.000,00", "R$ 250.000,00", "R$ 500.000,00"), "Dica: Um quarto de milhão de reais em dinheiro vivo."),
                CaseStep(12, "Nas fotos favoritas, onde o dinheiro roubado da conta do pai está fisicamente escondido?", "Encontre nos álbuns ou favoritos da Galeria a foto com as malas e sacos suspeitos.", "Em sacos do lixo numa lancha em Angra", listOf("No armário da casa de Curitiba", "Cofre da agência central do banco", "Em sacos do lixo numa lancha em Angra", "Enterrado nos fundos do quintal"), "Dica: Sacos plásticos pretos de lixo armazenados no barco em Angra."),
                CaseStep(13, "No extrato ou passagens do Trainline, para onde ele comprou passagem só de ida de fuga?", "Consulte no app de transportes Trainline as viagens futuras compradas.", "Comboio/Voo para a Suíça.", listOf("Voo de luxo para Paris", "Comboio/Voo para a Suíça.", "Fuga de ônibus para Argentina", "Passagem ao Uruguai"), "Dica: Destino clássico de dinheiro escondido e exílio na Europa."),
                CaseStep(14, "O app de Saúde estava ligado ao relógio inteligente do falecido pai. A que horas exatas o batimento cardíaco dele parou?", "Abra o app Saúde conectada do falecido pai e confira o horário da morte clínica.", "03:15", listOf("01:20", "03:15", "05:00", "00:00"), "Dica: Três horas e quinze minutos da madrugada."),
                CaseStep(15, "Consultando no Google Maps para essa mesma data e hora (03:15), onde Leandro estava localizado?", "Cruze o horário da morte com o histórico de rotas e pins salvos no Google Maps.", "No cartório de plantão.", listOf("No quarto do hospital com o pai", "Lavando o dinheiro na lancha", "No cartório de plantão.", "Em casa dormindo"), "Dica: Em um cartório aberto em horário especial."),
                CaseStep(16, "Onde está guardado secretamente o testamento legítimo completo de 100% que foi roubado?", "Procure no celular do Leandro o aplicativo de jogos Block Blast.", "Block Blast", listOf("Lixeira Protegida", "Google Drive Oculto", "Block Blast", "Notas Fechadas"), "Dica: O testamento original está trancado dentro do minijogo de blocos."),
                CaseStep(17, "Qual é o PIN correto de 4 dígitos para abrir o cofre escondido no jogo Block Blast?", "Insira o código correspondente às pistas recolhidas.", "0315", listOf("1992", "4412", "0315", "8192"), "Dica: É a hora exata em que o coração do pai parou de bater."),
                CaseStep(18, "O que revela o cofre criptografado de Block Blast como arquivo escondido?", "Abra o cofre após inserir a senha da hora do falecimento do pai.", "Testamento_Real_Papai.pdf", listOf("Testamento_Real_Papai.pdf", "Foto_Assinatura.png", "Copia_Chave_Banco.key", "Contrato_Lancha_Angra.pdf"), "Dica: O arquivo PDF real da última vontade do pai."),
                CaseStep(19, "O que consta escrito na linha principal desse Testamento Real legítimo?", "Examine as notas do PDF real desbloqueado no jogo.", "100% para Teresa.", listOf("50% para cada irmão", "100% para Teresa.", "Tudo doado para caridade", "90% para Leandro"), "Dica: Todo o patrimônio pertencia na verdade a sua irmã Teresa."),
                CaseStep(20, "Fase 3: Selecione o testamento verdadeiro com as fraudes do Photoshop e envie para as autoridades competentes.", "Faça o anexo correspondente das provas do Block Blast e envie para a polícia de elite no Gmail.", "Anexa o Testamento Real do Block Blast e as provas do Photoshop e envia para policia.fraudes@gov.br .", listOf("Anexa o Testamento Real do Block Blast e as provas do Photoshop e envia para policia.fraudes@gov.br .", "Mandar mensagem no whatsapp do Leandro zombando", "Apagar tudo", "Ligar para Teresa apenas"), "Dica: Remeta as provas direto para a delegacia anti-fraudes!")
            )
        ),

        CaseDefinition(
            id = 4,
            theme = "TRAIÇÃO ACADÊMICA",
            title = "Falsa Autoria",
            clientName = "Sofia (22, Estudante)",
            targetName = "Luana",
            clientBriefingMessages = listOf(
                "Eu ia apresentar meu TCC hoje, um projeto de urbanismo que demorei dois anos inteiros desenvolvendo.",
                "Mas a minha melhor amiga da faculdade, a Luana, apresentou o projeto dela antes de mim hoje cedo... e era o MEU projeto!",
                "Ela me roubou de forma descarada. Consegui pegar o celular dela temporariamente até a avaliação final, às 18h.",
                "Sofia implora: ache as provas digitais de que ela roubou meus arquivos de TCC e usou no projeto dela!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "college",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 82,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "👭 Sofia e Luana abraçadas", "Uma foto nossa abraçadas na faculdade.", isFavorite = true),
                    GalleryPhoto(2, "💻 Maquete Acadêmica", "Foto da maquete com TCC nota 10 chegando")
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Ninja (TI)",
                        lastMessage = "Trojan_Apagar_HD.exe",
                        lastTime = "Amanhã",
                        messages = listOf(
                            ChatMessage("Luana", "Preciso que apague o HD da Sofia hoje.", "Amanhã", isMe = true),
                            ChatMessage("Ninja (TI)", "Aqui está o vírus que deleta tudo: Trojan_Apagar_HD.exe", "Amanhã")
                        )
                    )
                ),
                walletTransactions = listOf(
                    WalletTransaction("Impressão 3D Express", "R$ 450,00", "Ontem"),
                    WalletTransaction("Hackers Ninja", "R$ 800,00", "Ontem")
                ),
                gmailInboxes = listOf(
                    GmailMessage(
                        "Gráfica Express",
                        "Recibo Maquete",
                        "Recibo impresso.",
                        "Ontem",
                        "Imposto pago para impressão 3D por Gráfica e Impressão 3D Express."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Pasta Projeto Secreto", "Projeto_FINAL_LUANA")
                ),
                mapPins = emptyList(),
                geminiQueries = listOf(
                    GeminiQuery("Como reescrever TCC alheio de urbanismo preservando significado mas alternando jargões para aprovação", "Para reescrever sem plágio visual, reestruture os parágrafos utilizando termos alternados.", "Ontem")
                )
            ),
            steps = listOf(
                CaseStep(1, "Qual é a imagem que define o fundo de tela (wallpaper) do celular da Luana?", "Observe a foto principal do ecrã.", "Uma foto nossa abraçadas na faculdade.", listOf("Fundo geométrico moderno", "Uma foto nossa abraçadas na faculdade.", "Ilustração de skyline", "Foto de grife famosa"), "Dica: É um registro antigo de amizade entre a Sofia e a Luana na própria faculdade."),
                CaseStep(2, "O que ela publicou orgulhosamente como história (Stories) no seu Instagram?", "Verifique o último story postado pela vilã Luana.", "Foto da maqueta com \"TCC nota 10 chegando!\".", listOf("Foto da maqueta com \"TCC nota 10 chegando!\".", "Foto tomando espumante", "Foto de malas prontas", "Selfie no espelho do banheiro"), "Dica: Ostentando a maquete roubada do TCC com predição de nota dez."),
                CaseStep(3, "Quantos áudios desesperados enviados por Sofia constam como ignorados no WhatsApp?", "Examine a contagem de bolinhas de notificação e mensagens não lidas de Sofia.", "12", listOf("3", "5", "12", "20"), "Dica: Uma dúzia de mensagens em áudio sem ouvir."),
                CaseStep(4, "A que horas exatas está agendada a defesa do TCC de Sofia no Calendário?", "Abra o Calendário acadêmico.", "18:00", listOf("14:00", "16:30", "18:00", "20:00"), "Dica: No final da tarde, às dezoito horas em ponto."),
                CaseStep(5, "Qual o nome configurado para o alarme agendado no Relógio para as 17h?", "Abra o Relógio nos agendamentos de alarmes ativos.", "Tomar calmante antes de apresentar", listOf("Tomar calmante antes de apresentar", "Revisar projeto final", "Apagar HD da Sofia", "Comemorar aprovação"), "Dica: Tem a ver com ansiedade e medo da Luana antes de apresentar sua mentira."),
                CaseStep(6, "Como ela conseguiu reescrever as 50 páginas roubadas rapidamente? O que buscou no Gemini?", "Estude o histórico de prompts no portal web do app Gemini.", "Prompt: \"Reescreve este projeto mudando o vocabulário para escapar ao plágio.\"", listOf("Prompt: \"Como burlar banca acadêmica\"", "Prompt: \"Reescreve este projeto mudando o vocabulário para escapar ao plágio.\"", "Como invadir computador de colega", "Projeto de urbanismo pronto para download"), "Dica: Pediu ajuda da Inteligência Artificial do Google."),
                CaseStep(7, "Onde ela guardou os ficheiros e a maquete 3D roubados no aplicativo de Notas?", "Abra o app Notas na raiz principal do celular.", "Pasta \"Projeto_FINAL_LUANA\"", listOf("Pasta de Rascunhos", "Pasta \"Projeto_FINAL_LUANA\"", "Sem título", "Macetes da Luana"), "Dica: Uma pasta com o título em formato maiúsculo."),
                CaseStep(8, "Com qual codinome ou criminoso digital ela conversou no WhatsApp para hackear e apagar o PC da colega?", "Abra o WhatsApp.", "Ninja (TI)", listOf("Mecânico Digital", "Ninja (TI)", "Felipe Vizinho", "Suporte Faculdade"), "Dica: Alguém especialista em infiltrações furtivas de computadores."),
                CaseStep(9, "Qual foi o arquivo destrutivo com extensão executável comprado para infectar a Sofia?", "Veja o envio do hacker na conversa do WhatsApp.", "Ficheiro \"Trojan_Apagar_HD.exe\"", listOf("Ficheiro \"TCC_Roubado.pdf\"", "Ficheiro \"Trojan_Apagar_HD.exe\"", "Script_Nuke.sh", "Faculdade_Acesso_Bypass.apk"), "Dica: Um Cavalo de Troia (Trojan) feito para apagar tudo."),
                CaseStep(10, "Qual foi o suborno pago via Apple Pay para esse hacker de PC?", "Veja as transações financeiras de saída de ontem no Apple Pay.", "R$ 800,00", listOf("R$ 150,00", "R$ 450,00", "R$ 800,00", "R$ 1.500,00"), "Dica: Oitocentos reais transferidos."),
                CaseStep(11, "Ache o recibo da confecção física da maquete acadêmica no Gmail. Qual o nome da loja?", "Veja as notas fiscais recebidas de serviços gráficos no Gmail.", "Gráfica e Impressão 3D Express", listOf("Copiadora Universitária", "Gráfica e Impressão 3D Express", "Maquetes & Modelos", "Papelaria Central"), "Dica: Serviço EXPRESS de impressão em três dimensões."),
                CaseStep(12, "No app Câmara, há um vídeo de ensaio gravado pela Luana. O que acontece nele?", "Reproduza o ensaio salvo nos vídeos locais.", "Ela erra os conceitos e admite não perceber nada do projeto.", listOf("Ela comemora a aprovação", "Ela erra os conceitos e admite não perceber nada do projeto.", "Aparece Sofia ajudando ela nas maquetes", "O vídeo está corrompido"), "Dica: Ela confessa abertamente que não faz a menor ideia da engenharia do projeto."),
                CaseStep(13, "A professora titular enviou uma dúvida crucial para o Gmail dela. Sobre qual página do TCC?", "Leia os e-mails acadêmicos recebidos no Gmail corporativo de Luana.", "Um erro de cálculo na página 14.", listOf("Falta de bibliografia", "Um erro de cálculo na página 14.", "Assinatura do orientador presa", "Plágio detectado pelo sistema"), "Dica: Uma inconsistência na página quatorze do relatório."),
                CaseStep(14, "O que a Luana pesquisou desesperadamente no Safari hoje de manhã após ler essa dúvida da banca?", "Analise o histórico de abas de busca web no Safari.", "Como calcular tensão de vigas de aço? Resumo rápido.", listOf("Como calcular tensão de vigas de aço? Resumo rápido.", "Como subornar secretária de curso", "Significado de urbanismo", "Como colar na apresentação"), "Dica: Um resumo rápido sobre vigas de aço estruturais."),
                CaseStep(15, "Abra o clássico jogo Snake (Cobrinha). Perca propositalmente 3 vezes seguidas marcando ZERO pontos. O que se abre com esse truque?", "Vá ao app de jogos Snake no celular e ative o easter-egg falhando 3 vezes seguidas no início.", "Uma \"Lixeira Protegida\" da Nuvem.", listOf("Um chat de conversas privadas", "Um PIN secreto da conta", "Uma \"Lixeira Protegida\" da Nuvem.", "O arquivo original do Word"), "Dica: Uma pasta de lixo oculta resgatada diretamente do servidor na Nuvem."),
                CaseStep(16, "O que está escondido e preservado nessa Lixeira Protegida secreta do Snake?", "Examine o conteúdo ocultado resgatado.", "Os rascunhos originais com o nome de Sofia.", listOf("Prints ameaçadores", "Os rascunhos originais com o nome de Sofia.", "Chave mestra de cPanel", "O código fonte do vírus Trojan"), "Dica: Arquivos textuais do projeto original de autoria da Sofia."),
                CaseStep(17, "Luana subornou a secretária da faculdade para adiantar o horário dela na banca. Veja o Mercado Pago. Qual o valor?", "Confira no Mercado Pago as transferências Pix recentes direcionadas.", "R$ 300,00", listOf("R$ 100,00", "R$ 300,00", "R$ 500,00", "R$ 800,00"), "Dica: Trezentos reais descritos como pagamento pelo remanejamento de horário."),
                CaseStep(18, "No app Notas, há um registro com a senha mestra para o Portal Universitário da Luana. Qual é a senha?", "Localize nas anotações soltas a senha de login.", "LuanaArquiteta123", listOf("SofiaAmiga123", "LuanaArquiteta123", "TCCnota10", "FaculArque2026"), "Dica: O nome dela seguido do cargo de seu sonho acadêmico e sequência numérica 123."),
                CaseStep(19, "Acesse o Portal Acadêmico no navegador Safari utilizando esse login. Qual o arquivo final que foi de fato submetido?", "Abra o Safari e inspecione a aba ativa do Portal do aluno.", "O projeto original ainda com os metadados da Sofia.", listOf("O projeto original ainda com os metadados da Sofia.", "O Word editado no Gemini", "Apenas uma maquete genérica", "Nenhum arquivo submetido ainda"), "Dica: O arquivo original que estranhamente ainda preserva os registros autorais da Sofia nas propriedades."),
                CaseStep(20, "Fase 3: Junte todo o acervo probatório e aniquile a mentira enviando ao canal da banca examinadora.", "Colha as provas do Gemini e do Snake e despache direto para o WhatsApp do grupo da coordenação.", "Reúne os prompts do Gemini e os originais do Snake. Envia tudo pelo WhatsApp diretamente para o grupo \"Banca de Avaliação - TCC\".", listOf("Reúne os prompts do Gemini e os originais do Snake. Envia tudo pelo WhatsApp diretamente para o grupo \"Banca de Avaliação - TCC\".", "Deletar a conta da Luana no portal universitário", "Remover todas as notas", "Fugir com o telefone correndo para a reitoria"), "Dica: Mande os prints de plágio do Gemini e fotos do Snake pro grupo 'Banca de Avaliação'!")
            )
        ),

        CaseDefinition(
            id = 5,
            theme = "TRAIÇÃO DE AMIGO",
            title = "O Padrinho",
            clientName = "Pedro (Noivo)",
            targetName = "Thiago",
            clientBriefingMessages = listOf(
                "Preciso de você, detetive. Vou me casar neste próximo sábado.",
                "O Thiago é meu amigo de infância e o escolhi para ser meu Padrinho de Casamento.",
                "Mas ando sentindo um clima extremamente estranho entre ele e a minha noiva. Algo secreto está acontecendo.",
                "Consegui o celular do Thiago por algumas horas. Por favor, remova as máscaras e descubra o que ele me oculta!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "sunset",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 85,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "🍺 Thiago e Pedro bebendo cerveja", "Uma foto dos dois (Pedro e Thiago) a beberem cerveja.", isFavorite = true),
                    GalleryPhoto(2, "👗 Noiva em lingerie vermelha", "A noiva do Pedro, a usar uma lingerie vermelha.", isDeleted = false, isFavorite = true)
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Pedro Amigo (Noivo)",
                        lastMessage = "Tudo pronto pra amanhã, padrinho?",
                        lastTime = "Ontem",
                        messages = listOf(
                            ChatMessage("Pedro Amigo", "Tudo pronto pra amanhã, padrinho?", "Ontem")
                        )
                    ),
                    WhatsAppChat(
                        contactName = "Noiva do Pedro (Amante)",
                        lastMessage = "Já fiz as malas. Fujo pela porta dos fundos.",
                        lastTime = "Amanhã",
                        isArchived = true,
                        messages = listOf(
                            ChatMessage("Leandro", "Não aguento mais esse casamento falso.", "Ontem", isMe = true),
                            ChatMessage("Noiva", "Fica calmo, vamos fugir juntos.", "Ontem")
                        )
                    )
                ),
                walletTransactions = emptyList(),
                gmailInboxes = listOf(
                    GmailMessage(
                        "Loja Noivos de Luxo",
                        "Recibo de Fato de Linho",
                        "Detalhes do pedido do fato.",
                        "Ontem",
                        "Confirmação de compra do Fato de Linho Azul Marinho comprado por Thiago."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Carta de Amor Secr", "Não podes casar com ele no sábado...")
                ),
                mapPins = emptyList(),
                geminiQueries = emptyList()
            ),
            steps = listOf(
                CaseStep(1, "Qual é a foto de perfil do Thiago no WhatsApp de amizade?", "Visualize a foto de perfil no app de mensagens WhatsApp.", "Uma foto dos dois (Pedro e Thiago) a beberem cerveja.", listOf("Uma foto dos dois (Pedro e Thiago) a beberem cerveja.", "Foto do terno de noiva", "Fundo preto da logo da empresa", "Selfie tirada na academia"), "Dica: Os dois melhores amigos felizes brindando copos com chope."),
                CaseStep(2, "Qual é o principal evento cadastrado para amanhã no Calendário dele?", "Abra o Calendário pessoal do padrinho.", "Casamento do meu irmão Pedro", listOf("Viagem corporativa Argentina", "Casamento do meu irmão Pedro", "Retirada do anel de ouro", "Festa dos Padrinhos"), "Dica: O dia solene do seu grande amigo Pedro."),
                CaseStep(3, "Que tipo de terno de grife ele comprou na loja online? Veja no Gmail.", "Cheque as mensagens de confirmação de e-commerce no Gmail.", "Fato de Linho Azul Marinho", listOf("Fato Oxford Preto Clássico", "Fato de Linho Azul Marinho", "Smoking Cinza Moderno", "Fraque Tradicional Grafite"), "Dica: Um modelo leve feito de linho em tom azulado."),
                CaseStep(4, "No app Spotify, qual é o título da playlist que consta fixada no topo de escutas?", "Abra o Spotify do celular do alvo.", "A Nossa Noite Secreta", listOf("Viagem Buenos Aires", "Casamento Músicas Entrada", "A Nossa Noite Secreta", "Amigos para Sempre Remix"), "Dica: Título sugestivo que envolve encontros nas sombras."),
                CaseStep(5, "Ao olhar os detalhes dessa playlist de topo, qual motel nela cadastrado serve de ponto?", "Confira a descrição longa ou detalhes da playlist do Spotify.", "Motel 'Paraíso das Nuvens'", listOf("Motel 'Paraíso das Nuvens'", "Hotel Plaza Prime", "Chalé Verde das Colinas", "Pousada Flor de Cerejeira"), "Dica: Nome poético com paraíso e nuvens no título."),
                CaseStep(6, "No app de Câmara escondido nos Favoritos de mídia, quem aparece em foto comprometedora?", "Abra a Galeria do celular -> Pasta Favoritos protegida.", "A noiva do Pedro, a usar uma lingerie vermelha.", listOf("A noiva do Pedro, a usar uma lingerie vermelha.", "Pedro em um quarto de hotel", "A amante Priscila em Buenos Aires", "Desenhos de escrituras imobiliárias"), "Dica: A futura esposa do melhor amigo dele vestindo cor escarlate."),
                CaseStep(7, "Nas Notas soltas, há um rascunho de uma carta de amor secreta não enviada. Como ela se inicia?", "Examine os rascunhos de correspondência no Notas.", "Não podes casar com ele no sábado...", listOf("Querido Thiago, não aguento mais...", "Não podes casar com ele no sábado...", "Plano de fuga confirmado para segunda", "Pedido de desculpas sinceras"), "Dica: Apelo direto implorando para cancelar a união matrimonial de sábado."),
                CaseStep(8, "Thiago enviou uma grande quantia via Pix para a noiva do amigo pelo Mercado Pago. Qual era a descrição?", "Abra as transferências bancárias no Mercado Pago.", "Para a tua parte do nosso voo", listOf("Suborno das alianças", "Para a tua parte do nosso voo", "Aluguel semanal do apartamento", "Presente de Casamento"), "Dica: Destinado ao custeio de bilhetes aéreos de fuga."),
                CaseStep(9, "Segundo as reservas aéreas no app de transportes Trainline, para onde eles pretendem fugir?", "Veja no histórico de bilhetes ativos do app Trainline.", "Voo de madrugada para Buenos Aires.", listOf("Voo de madrugada para Buenos Aires.", "Passagem de balsa às Ilhas Cayman", "Fuga terrestre para Montevidéu", "Férias prolongadas para Cancun"), "Dica: Capital mundial do tango na Argentina."),
                CaseStep(10, "Eles usam um chat ocultado no Snapchat para combinar a traição. Qual é o apelido do contato dela lá?", "Procure pelas conversas secretas do Snapchat.", "Borboleta 🦋", listOf("Estrela Cadente ✨", "Borboleta 🦋", "Diva Secreta 💎", "Gatinha 🐾"), "Dica: Um inseto belo de asas coloridas acompanhado de emoji."),
                CaseStep(11, "No Snapchat, há um vídeo que expira em que ela confessa o plano de fuga de madrugada. O que ela diz?", "Abra as mídias temporárias em conversas salvas.", "Já fiz as malas. Quando o Pedro adormecer, fujo pela porta dos fundos.", listOf("Estou com medo da Carla descobrir tudo.", "Já fiz as malas. Quando o Pedro adormecer, fujo pela porta dos fundos.", "Não consigo assinar o documento falsificado.", "O anel de diamante fake está lindo."), "Dica: Explica o plano de escapar furtivamente à noite enquanto o noivo dorme."),
                CaseStep(12, "O que Thiago pesquisou secretamente no assistente de IA Gemini recentemente?", "Veja o log de buscas do Gemini.", "Como cancelar vistos de casamento no civil", listOf("Como ocultar traição de amizades", "Como cancelar vistos de casamento no civil", "Onde comprar joias falsas baratas", "Como falsificar assinatura civil"), "Dica: Queria inviabilizar a certidão jurídica matrimonial."),
                CaseStep(13, "Thiago comprou uma réplica falsa barata da aliança no Apple Pay. Quanto custou a imitação?", "Examine o histórico recente do Apple Pay de joias baratas.", "R$ 150,00", listOf("R$ 150,00", "R$ 1.500,00", "R$ 5.000,00", "R$ 12.000,00"), "Dica: Apenas cento e cinquenta reais de bijoux barulhenta."),
                CaseStep(14, "Onde está escondida a aliança real roubada do casal? Quebre os recordes do minijogo Block Blast com pontuação 100 para descobrir o código.", "Abra o minijogo Block Blast para ler o código obtido de recompensa.", "Cacifo 4B da Estação de Comboios.", listOf("Cacifo 4B da Estação de Comboios.", "Cofre número 8192 na sala de estar", "Sob o pneu de estepe do carro", "Lixeira do vestiário da fábrica"), "Dica: Um compartimento público número quatro B em uma central rodoviária/ferroviária."),
                CaseStep(15, "No app Telefone, para qual órgão ele ligou insistentemente dez vezes ontem à noite?", "Consulte no telefone os números chamados por ele.", "Conservatória - Registo Civil", listOf("Delegacia Civil da Capital", "Conservatória - Registo Civil", "IML Central", "Advocacia Geral de Família"), "Dica: Onde ocorrem os casamentos civis legais."),
                CaseStep(16, "No Scanner de documentos, qual arquivo está processado na fila?", "Estude os PDFs do app Scanner.", "Bilhetes de identidade escaneados para o check-in do voo duplo.", listOf("Contrato de locação comercial", "Bilhetes de identidade escaneados para o check-in do voo duplo.", "Contrato de divórcio assinado", "Fatura de hotel em Buenos Aires"), "Dica: IDs prontas para embarcar no voo duplo internacional de amanhã."),
                CaseStep(17, "Abra o app de Bússola e clique exatamente no centro. Qual documento chocante estava ocultado no compartimento?", "Utilize a interface da Bússola com o macete de clicar no centro para revelar arquivos criptografados.", "O contrato de venda do apartamento que o Pedro tinha comprado. A noiva passou para o Thiago!", listOf("O testamento original da herança", "O contrato de venda do apartamento que o Pedro tinha comprado. A noiva passou para o Thiago!", "Faturas do motel clandestino", "Lista de subornos corporativos"), "Dica: Envolve repassar a posse do apartamento de Pedro direto para o Thiago via falcatrua imobiliária."),
                CaseStep(18, "Qual o nome do corretor de imóveis corrupto que autorizou isso nas mensagens SMS?", "Procure nas conversas de texto do SMS a aprovação comercial.", "Sr. Osvaldo", listOf("Inspetor Torres", "Sr. Osvaldo", "Doutor Silveira", "Tio Patinhas"), "Dica: Começa com Senhor Osvaldo."),
                CaseStep(19, "Ao abrir o Photoshop, qual arquivo recente ele esteve manipulando no aplicativo?", "Encontre os prints ou rascunhos de edição de imagem no celular.", "A assinatura do Pedro na escritura.", listOf("O rosto de Sofia nas fotos", "A assinatura do Pedro na escritura.", "Contrato de lancha esportiva", "Extrato falso de Mercado Pago"), "Dica: Forjou a assinatura legal de Pedro na aquisição do imóvel."),
                CaseStep(20, "Fase 3: Junte o voo do Trainline, vídeo do Snapchat e Photoshop fraudado e mande no WhatsApp de Pedro para acabar com seu casamento cilada.", "Selecione as três mídias de prova e anexe na mensagem de contato do Pedro.", "Seleciona o voo do Trainline, o vídeo do Snapchat e a escritura falsificada do Photoshop. Envia tudo pelo WhatsApp para Pedro antes do casamento começar.", listOf("Seleciona o voo do Trainline, o vídeo do Snapchat e a escritura falsificada do Photoshop. Envia tudo pelo WhatsApp para Pedro antes do casamento começar.", "Apagar as fotos e fingir inocência", "Esvaziar a conta corrente do Mercado Pago", "Agredir Thiago fisicamente"), "Dica: Desmascare a fraude civil com a tríade de provas no WhatsApp!")
            )
        )
    )

    val dossierCasesList: List<DossierItem> = listOf(
        DossierItem(1, "https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=120", "O Quarto Vazio", "Alvo: Diego", "Carla (32)", "TRAIÇÃO AMOROSA"),
        DossierItem(2, "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=120", "Sociedade Falida", "Alvo: Marcos", "Beto (28)", "TRAIÇÃO FINANCEIRA"),
        DossierItem(3, "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=120", "Sangue do Meu Sangue", "Alvo: Leandro", "Teresa (50)", "TRAIÇÃO FAMILIAR"),
        DossierItem(4, "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=120", "Falsa Autoria", "Alvo: Luana", "Sofia (22)", "TRAIÇÃO ACADÊMICA"),
        DossierItem(5, "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=120", "O Padrinho", "Alvo: Thiago", "Pedro (30)", "TRAIÇÃO DE AMIGO"),
        DossierItem(6, "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?w=120", "A Noiva em Fuga", "Alvo: Amanda", "Marcos (34)", "DESAPARECIMENTO 1"),
        DossierItem(7, "https://images.unsplash.com/photo-1519085360753-af0119f7cbe7?w=120", "O Acampamento", "Alvo: Lucas", "Marta (48)", "DESAPARECIMENTO 2"),
        DossierItem(8, "https://images.unsplash.com/photo-1531746020798-e6953c6e8e04?w=120", "Dupla Identidade", "Alvo: Roberto", "Vanessa (38)", "TRAIÇÃO AMOROSA"),
        DossierItem(9, "https://images.unsplash.com/photo-1560250097-0b93528c311a?w=120", "Segredo Industrial", "Alvo: Carlos", "Dir. Recursos Humanos", "ESPIONAGEM CORP"),
        DossierItem(10, "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?w=120", "A Ameaça Digital", "Alvo: Felipe (Vinho)", "Alice (24)", "CRIME CIBERNÉTICO"),
        DossierItem(11, "https://images.unsplash.com/photo-1554151228-14d9def656e4?w=120", "O Culto do Eclipse", "Alvo: Membro Anônimo", "Det. Silva (Polícia)", "SUSPENSE E MISTÉRIO")
    )

    fun getOrGenerateCase(id: Int): CaseDefinition {
        val found = allCases.find { it.id == id }
        if (found != null) return found

        return when (id) {
            6 -> generateCase6()
            7 -> generateCase7()
            8 -> generateCase8()
            9 -> generateCase9()
            10 -> generateCase10()
            11 -> generateCase11()
            else -> allCases[0]
        }
    }

    private fun generateCase6(): CaseDefinition {
        return CaseDefinition(
            id = 6,
            theme = "DESAPARECIMENTO",
            title = "A Noiva em Fuga",
            clientName = "Marcos (31, Engenheiro)",
            targetName = "Amanda",
            clientBriefingMessages = listOf(
                "Detetive, a minha noiva sumiu do camarim minutos antes de subirmos ao altar!",
                "Ela esqueceu o celular de trabalho dela no carro. Ela nunca sairia sem avisar espontaneamente.",
                "Tenho medo que o ex-namorado doente dela, o Ricardo, tenha feito algo terrível.",
                "Por favor, ajude-me a traçar os passos físicos que ela deu e descobrir onde ela está escondida!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "dog",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 52,
                currentNetworkTime = "14:20",
                galleryPhotos = listOf(
                    GalleryPhoto(1, "🐶 Cachorrinho Bolinha", "Foto do cão dela, o \"Bolinha\"", isFavorite = true),
                    GalleryPhoto(2, "👗 Maquiagem Dia", "Foto se preparando para o casamento"),
                    GalleryPhoto(3, "🚌 Terminal Rodoviário", "Foto do guichê da rodoviária")
                ),
                whatsappChats = listOf(
                    WhatsAppChat(
                        contactName = "Marcos Noivo",
                        lastMessage = "Amor, estás atrasada. O padre já chegou.",
                        lastTime = "Amanhã",
                        messages = listOf(
                            ChatMessage("Marcos Noivo", "Amor, estás atrasada. O padre já chegou.", "12:00")
                        )
                    ),
                    WhatsAppChat(
                        contactName = "Felipe Vizinho",
                        lastMessage = "Oi, vou dar comida pro Bolinha hoje, pode ir tranquila.",
                        lastTime = "Ontem",
                        messages = listOf(
                            ChatMessage("Felipe", "Oi, vou dar comida pro Bolinha hoje, pode ir tranquila.", "Ontem")
                        )
                    )
                ),
                walletTransactions = listOf(
                    WalletTransaction("Saque ATM Multibanco Shopping", "R$ 500,00", "Ontem"),
                    WalletTransaction("Airbnb Estada", "R$ 1.200,00", "Ontem")
                ),
                gmailInboxes = listOf(
                    GmailMessage(
                        "Resgate de Ticket",
                        "Bilhete de ônibus confirmado",
                        "Embarque amanhã.",
                        "Ontem",
                        "Seu bilhete de ônibus rodoviário com escala para a pacata cidade de Pouso Alegre foi computado."
                    )
                ),
                notes = listOf(
                    NoteEntry(1, "Diário Íntimo Secreto 🔐", "Ele encontrou-me. Tenho de proteger o Marcos.", isLocked = true, pinCode = "1402")
                ),
                mapPins = listOf(
                    MapPinDefinition("Escala Rodoviária", "Terminal Rodoviário", "-23.51, -46.62", "Último sinal do GPS")
                ),
                geminiQueries = listOf(
                    GeminiQuery("Como desativar rastreamento do smartwatch de forma invisível", "Você pode desativar a rede sem fio e o compartilhamento familiar de localização nas configurações da Apple/Google.", "Hoje")
                )
            ),
            steps = listOf(
                CaseStep(1, "O que está na tela de bloqueio do telemóvel dela?", "Examine o Fotos para ver fotos do cachorro ou wallpapers.", "Foto do cão dela, o \"Bolinha\"", listOf("Foto do cão dela, o \"Bolinha\"", "Foto do casamento", "Fundo de Paris", "Nenhuma foto, padrão cinza"), "Dica: É o amado cachorrinho de estimação dela."),
                CaseStep(2, "No Instagram, qual foi o último Story publicado?", "Confira o andamento estático dos stories no Instagram da noiva.", "A preparar a maquilhagem! O grande dia!", listOf("Prestes a dizer o sim!", "A preparar a maquilhagem! O grande dia!", "Pegando a estrada", "Bolinha triste no sofá"), "Dica: Preparando a maquiagem para subir ao altar."),
                CaseStep(3, "Nas mensagens de WhatsApp dela, qual a última mensagem enviada por Marcos?", "Abra o chat ativo de Marcos.", "Sim, \"Amor, estás atrasada. O padre já chegou.\"", listOf("Estou te esperando amor!", "Sim, \"Amor, estás atrasada. O padre já chegou.\"", "Você me traiu?", "Não vá embora!"), "Dica: Aponta sobre o atraso dela e chegada do padre."),
                CaseStep(4, "Veja a última localização GPS dela marcada no Google Maps.", "Abra o aplicativo Maps.", "Terminal Rodoviário", listOf("Terminal Rodoviário", "Aeroporto Internacional", "Cabana nas Ondas", "Igreja Central"), "Dica: Estação de ônibus rodoviária."),
                CaseStep(5, "Usa a data do aniversário de noivado para abrir as Notas trancadas. Qual a data?", "A senha é dia e mês juntinhos. Procure em Marcos Chats ou Calendário.", "1402", listOf("1206", "1402", "2512", "2016"), "Dica: Quatorze de fevereiro (14/02)."),
                CaseStep(6, "O que diz a nota protegida de rascunho com a senha 1402?", "Consulte o bloco de notas aberto com o PIN de segurança.", "Ele encontrou-me. Tenho de proteger o Marcos.", listOf("Ele encontrou-me. Tenho de proteger o Marcos.", "Estou fugindo com o padrinho Thiago", "Estou grávida e fugi com outro", "Fui sequestrada, me ajuda"), "Dica: Ela afirma com pânico que 'Ele' a encontrou e quer proteger Marcos."),
                CaseStep(7, "Quem a encontrou de fato nas mensagens SMS bloqueadas?", "Abra do SMS a seção de remetentes bloqueados e filtre.", "Ricardo Ex", listOf("Ricardo Ex", "Tio Patinhas", "Sócio Marcos", "Doutor Silveira"), "Dica: O ex abusivo 'Ricardo Ex' que ameaçou acabar com a vida de Marcos."),
                CaseStep(8, "Como Ricardo sabia de cada passo físico dela? Veja no app Saúde.", "Veja as conexões de compartilhamento de biometria e localização familar no app Saúde.", "Ele tinha acesso partilhado à localização do Apple Watch dela.", listOf("Ele colocou bug físico no carro", "Ele tinha acesso partilhado à localização do Apple Watch dela.", "Ele seguia ela nas ruas", "Sócio passou a rota secreta"), "Dica: Rastreamento clandestino via compartilhamento do Apple Watch."),
                CaseStep(9, "O que ela pesquisou desesperadamente no Gemini em pânico?", "Examine as consultas de ajuda no Gemini.", "Como desativar rastreamento do smartwatch de forma invisível", listOf("Como desativar rastreamento do smartwatch de forma invisível", "Delegacia de Mulheres próximo", "Como apagar histórico de ônibus", "Como fugir de agressão"), "Dica: Desativar a localização do relógio sem que o ex notasse."),
                CaseStep(10, "Para qual destino ela comprou passagem na pressa no app de passagens (Trainline)?", "Abra o Trainline.", "Autocarro para a cidade de Pouso Alegre.", listOf("Voo para o Rio de Janeiro", "Autocarro para a cidade de Pouso Alegre.", "Voo para Portugal", "Voo para Suíça"), "Dica: Destino rodoviário a bordo de ônibus para Pouso Alegre."),
                CaseStep(11, "Como ela conseguiu pagar o ônibus sem deixar registros no Mercado Pago?", "Verifique o extrato e saques do Mercado Pago.", "Saque em dinheiro de R$ 500,00 no multibanco do shopping.", listOf("Transferência bancária secreta", "Saque em dinheiro de R$ 500,00 no multibanco do shopping.", "Usou o Apple Pay pessoal", "Doação de amigos próximos"), "Dica: Sacou dinheiro de quinhentos reais em espécie para passar despercebida."),
                CaseStep(12, "Ela alugou um quarto remoto sob que nome de propriedade no Airbnb?", "Cheque o app Airbnb do celular.", "Sítio Refúgio - Em nome da sua tia Alice.", listOf("Cabana de Madeira do Bosque", "Sítio Refúgio - Em nome da sua tia Alice.", "Hotel Central City", "Quarto Aconchegante do Rio"), "Dica: Sítio Refúgio, disfarçado sob o documento da tia Alice."),
                CaseStep(13, "Na aba de memórias do Snapchat, qual vídeo dela chorando revela pistas?", "Visualize o Snapchat.", "Marcos, perdoa-me. Eu amo-te, mas tenho de despistar o Ricardo. O Bolinha está seguro com a vizinha.", listOf("Marcos, perdoa-me. Eu amo-te, mas tenho de despistar o Ricardo. O Bolinha está seguro com a vizinha.", "Eu não amo mais você", "Vou fugir com o padrinho Thiago de helicóptero", "Fui assaltada próximo à rodoviária"), "Dica: Explica o pânico de despistar Ricardo e segurança do cachorro Bolinha."),
                CaseStep(14, "Para onde o Ricardo doente supõe que ela escapou? Olhe as falsas buscas no Safari.", "Estude as últimas pesquisas plantadas de propósito no histórico do Safari.", "Voos baratos para Portugal", listOf("Voos baratos para Portugal", "Hoteis em Miami de luxo", "Encontros na Argentina", "Ônibus Pouso Alegre barato"), "Dica: Pesquisas falsas sobre voos baratos dirigidos a Portugal."),
                CaseStep(15, "Abra o jogo BrickBreaker. Perca logo no início de propósito para expor um contato. Quem é o contato?", "Inicie o jogo BrickBreaker e solte a bola imediatamente sem rebater.", "Inspetor Torres - Proteção a Testemunhas.", listOf("Inspetor Torres - Proteção a Testemunhas.", "Delegado Civil de Fraudes", "Tia Alice Aluguéis", "Investigador Policial Silva"), "Dica: Membro da força de Proteção a Testemunhas."),
                CaseStep(16, "Quanto tempo exato durou o telefonema entre ela e esse Inspetor Torres?", "Verifique as chamadas de voz efetuadas e recebidas no app Telefone.", "45 minutos.", listOf("5 minutos.", "15 minutos.", "45 minutos.", "1 hora inteiro"), "Dica: Quarenta e cinco minutos de pura cooperação policial."),
                CaseStep(17, "O que continham as fotos em anexo que ela enviou para o Inspetor?", "Examine as fotos anexadas nos chats.", "Provas das ameaças físicas do Ricardo antigas.", listOf("Fotos do carro novo", "Provas das ameaças físicas do Ricardo antigas.", "Rascunhos de TCC plagiado", "Prints do extrato bancário"), "Dica: Evidências anteriores de violência física exercida por Ricardo."),
                CaseStep(18, "No app Meteorologia, a temperatura onde ela está bate de fato com a do Airbnb?", "Cruze a temperatura do clima com a hospedagem.", "Sim, 15°C (Frio de serra em Pouso Alegre).", listOf("Não, lá está calor de 35C", "Sim, 15°C (Frio de serra em Pouso Alegre).", "Não, clima desértico", "Está chovendo forte lá"), "Dica: Clima de serra ameno marcando exatamente quinze graus Celsius."),
                CaseStep(19, "Qual é o número exato de assento do bilhete salvo no Calendário pessoal?", "Abra o Calendário.", "Assento 12B.", listOf("Assento 3A.", "Assento 12B.", "Passageiro Extra 1", "Assento do carona"), "Dica: Assento doze B."),
                CaseStep(20, "Fase 3: Junte o testamento das pistas e envie os dados em anexo por e-mail para salvar Amanda das ameaças e tranquilizar Marcos.", "Selecione as fotos do Snapchat e despacho do Trainline no Gmail de Amanda enviando para o aflito Marcos.", "Vai ao Gmail. Escreve para o Marcos anexando o vídeo do Snapchat e o bilhete do Trainline, revelando que ela está viva, a protegê-lo e já contactou a polícia.", listOf("Vai ao Gmail. Escreve para o Marcos anexando o vídeo do Snapchat e o bilhete do Trainline, revelando que ela está viva, a protegê-lo e já contactou a polícia.", "Bloquear o sócio de Marcos no WhatsApp", "Acionar a SWAT armada no aeroporto", "Fingir que não achou nada"), "Dica: Remeta o e-mail acalmando o noivo mostrando que as forças policiais da testemunha já intervieram!")
            )
        )
    }

    private fun generateCase7(): CaseDefinition = createFallbackCase(7, "O Acampamento", "TRAIÇÃO", "Lucas", "Às 17:15.", "Latitude -22.543, Longitude -43.123.", "Caverna Norte do Rio da Garganta.")
    private fun generateCase8(): CaseDefinition = createFallbackCase(8, "Dupla Identidade", "TRAIÇÃO", "Roberto", "Colégio Infantil Aquarela", "Amanda Costa", "Cópias das certidões de nascimento do Júnior com o nome do Roberto como pai.")
    private fun generateCase9(): CaseDefinition = createFallbackCase(9, "Segredo Industrial", "ESPIONAGEM", "Carlos", "CEO da \"JetDynamics\" (Empresa rival Chinesa).", "ID: 4099", "Fotos dos protótipos do Motor X-7.")
    private fun generateCase10(): CaseDefinition = createFallbackCase(10, "A Ameaça Digital", "CRIME CIBERNÉTICO", "Felipe", "GhostNet_Alpha", "Felipe Andrade", "O hacker é, na verdade, o \"Felipe\", o vizinho simpático do 3º andar que ajuda a Alice com as compras.")
    private fun generateCase11(): CaseDefinition = createFallbackCase(11, "O Culto do Eclipse", "SUSPENSE", "Culto", "Eclipse Solar Total.", "777", "O Guia da Passagem")

    private fun createFallbackCase(id: Int, title: String, theme: String, target: String, ans1: String, ans2: String, ans3: String): CaseDefinition {

        return CaseDefinition(
            id = id,
            theme = theme,
            title = title,
            clientName = "Cliente do Caso $id",
            targetName = target,
            clientBriefingMessages = listOf(
                "Olá Detetive, fui direcionado a você para resolver urgentemente o Caso $title.",
                "Este celular contem todos os rastros que foram deixados pelo alvo $target.",
                "Preciso que você investigue as entranhas digitais das aplicações do dispositivo e responda os 20 passos interativos.",
                "Não hesite em usar canais de dica se ficar encurralado!"
            ),
            phoneData = CasePhoneData(
                wallpaperType = "sunset",
                wifiNetwork = "Starbucks_Free",
                batteryPct = 3,
                currentNetworkTime = "13:50",
                employeeCode = "4099",
                healthSteps = 14000,
                healthHeartLogs = listOf("Stress extremo às 13:50"),
                notes = listOf(
                    NoteEntry(1, "Documento Secreto", "Guia do Caso - Senha de acesso e ID é 4099 ou 777.", isLocked = true, pinCode = "777"),
                    NoteEntry(2, "Diário Interno", "Rastro do caso de espionagem e pânico corporal.")
                )
            ),
            steps = (1..20).map { step ->
                val ans = when (step) {
                    1 -> ans1
                    5 -> ans2
                    17 -> ans2
                    18 -> ans3
                    19 -> ans3
                    else -> "Resposta Correta Passo $step"
                }
                CaseStep(
                    stepNum = step,
                    question = "Passo $step do caso $title: Qual a evidência chave do suspeito $target?",
                    actionNeeded = "Examine os aplicativos celular do alvo como Fotos, Mensagens ou Configurações.",
                    correctAnswer = ans,
                    options = listOf(ans, "Pista Falsa A", "Evidência Secundária", "Rastro editado"),
                    hint = "A pista para resolver este puzzle é diretamente: $ans"
                )
            }
        )
    }
}

data class DossierItem(
    val id: Int,
    val avatarUrl: String,
    val title: String,
    val subtitle: String,
    val client: String,
    val category: String
)
