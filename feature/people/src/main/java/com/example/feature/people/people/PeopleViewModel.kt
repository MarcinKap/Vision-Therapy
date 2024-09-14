package com.example.feature.people.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.coroutines.IO
import com.example.core.model.Client
import com.example.core.model.Worker
import com.example.data.client.usecase.GetClientsUseCase
import com.example.data.client.usecase.SaveClientsUseCase
import com.example.data.workschedule.usecase.GetWorkersUseCase
import com.example.data.workschedule.usecase.SaveWorkerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getWorkersUseCase: GetWorkersUseCase,
    private val saveWorkerUseCase: SaveWorkerUseCase,
    private val getClientsUseCase: GetClientsUseCase,
    private val saveClientsUseCase: SaveClientsUseCase,
    @IO private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PeopleUiState())
    val uiState: StateFlow<PeopleUiState> = _uiState.asStateFlow()

    private val uiStateValue: PeopleUiState
        get() = uiState.value

    init {
        generateInitWorkers()
        generateInitClients()

        collectData()
    }

    internal fun onAction(action: PeopleUiAction) {
        when (action) {
            PeopleUiAction.SelectClientsTab -> updateSelectedFilter(PeopleFilter.Clients)
            PeopleUiAction.SelectWorkersTab -> updateSelectedFilter(PeopleFilter.Workers)
            is PeopleUiAction.OpenWorker -> {}
        }
    }

    private fun updateSelectedFilter(filter: PeopleFilter) {
        _uiState.update {
            it.copy(selectedFilter = filter)
        }
    }

    private fun collectData() {
        viewModelScope.launch(ioDispatcher) {
            combine(
                getWorkersUseCase.invoke(),
                getClientsUseCase.invoke(),
            ) { workers, clients ->
                uiStateValue.copy(
                    workers = workers,
                    clients = clients,
                )
            }.collect { newUiState ->
                _uiState.value = newUiState
            }
        }
    }

    private fun generateInitWorkers() {
        viewModelScope.launch(ioDispatcher) {
            saveWorkerUseCase.invoke(
                listOf(
                    Worker(
                        id = "1",
                        name = "Jan",
                        surname = "Kowalski",
                        position = "Optometrysta",
                        createdAt = OffsetDateTime.now(),
                        startDate = LocalDate.now(),
                        endDate = null,
                        email = "jan.kowalski@optyka.pl",
                    ),
                    Worker(
                        id = "2",
                        name = "Danuta",
                        surname = "Nowak",
                        position = "Obsługa Klienta",
                        createdAt = OffsetDateTime.now(),
                        startDate = LocalDate.now(),
                        endDate = null,
                        email = "danuta.nowak@optyka.pl",
                    ),
                    Worker(
                        id = "3",
                        name = "Anna",
                        surname = "Wiśniewska",
                        position = "Sprzedawca",
                        createdAt = OffsetDateTime.now(),
                        startDate = LocalDate.of(2022, 5, 10),
                        endDate = null,
                        email = "anna.wisniewska@optyka.pl",
                    ),
                    Worker(
                        id = "4",
                        name = "Michał",
                        surname = "Zieliński",
                        position = "Technik Optyk",
                        createdAt = OffsetDateTime.now(),
                        startDate = LocalDate.of(2020, 2, 15),
                        endDate = null,
                        email = "michal.zielinski@optyka.pl",
                    ),
                ),
            )
        }
    }

    private fun generateInitClients() {
        viewModelScope.launch(ioDispatcher) {
            saveClientsUseCase.invoke(
                listOf(
                    Client(
                        id = "1",
                        firstName = "John",
                        lastName = "Doe",
                        phoneNumber = "123456789",
                        email = "john.doe@example.com",
                        prescriptionNumber = "RX001",
                        lastVisitDate = LocalDate.of(2023, 5, 10),
                        comments = "Wears glasses for distance",
                    ),
                    Client(
                        id = "2",
                        firstName = "Jane",
                        lastName = "Smith",
                        phoneNumber = "987654321",
                        email = "jane.smith@example.com",
                        prescriptionNumber = "RX002",
                        lastVisitDate = LocalDate.of(2023, 6, 14),
                        comments = "Requires bifocals",
                    ),
                    Client(
                        id = "3",
                        firstName = "Emily",
                        lastName = "Johnson",
                        phoneNumber = "555123456",
                        email = "emily.johnson@example.com",
                        prescriptionNumber = "RX003",
                        lastVisitDate = LocalDate.of(2023, 7, 20),
                        comments = null,
                    ),
                    Client(
                        id = "4",
                        firstName = "Michael",
                        lastName = "Brown",
                        phoneNumber = "444987654",
                        email = "michael.brown@example.com",
                        prescriptionNumber = "RX004",
                        lastVisitDate = LocalDate.of(2023, 8, 15),
                        comments = "Ordered progressive lenses",
                    ),
                    Client(
                        id = "5",
                        firstName = "Sarah",
                        lastName = "Davis",
                        phoneNumber = "333654987",
                        email = "sarah.davis@example.com",
                        prescriptionNumber = "RX005",
                        lastVisitDate = LocalDate.of(2023, 9, 1),
                        comments = "Needs new frames",
                    ),
                    Client(
                        id = "6",
                        firstName = "Chris",
                        lastName = "Miller",
                        phoneNumber = "222789456",
                        email = "chris.miller@example.com",
                        prescriptionNumber = "RX006",
                        lastVisitDate = LocalDate.of(2023, 4, 12),
                        comments = "Prefers contact lenses",
                    ),
                    Client(
                        id = "7",
                        firstName = "Jessica",
                        lastName = "Wilson",
                        phoneNumber = "111123789",
                        email = "jessica.wilson@example.com",
                        prescriptionNumber = "RX007",
                        lastVisitDate = LocalDate.of(2023, 10, 3),
                        comments = null,
                    ),
                    Client(
                        id = "8",
                        firstName = "Daniel",
                        lastName = "Taylor",
                        phoneNumber = "666852369",
                        email = "daniel.taylor@example.com",
                        prescriptionNumber = "RX008",
                        lastVisitDate = LocalDate.of(2023, 11, 11),
                        comments = "Has astigmatism",
                    ),
                    Client(
                        id = "9",
                        firstName = "Anna",
                        lastName = "Martinez",
                        phoneNumber = "777963258",
                        email = "anna.martinez@example.com",
                        prescriptionNumber = "RX009",
                        lastVisitDate = LocalDate.of(2023, 3, 30),
                        comments = "Needs prescription sunglasses",
                    ),
                    Client(
                        id = "10",
                        firstName = "Robert",
                        lastName = "Anderson",
                        phoneNumber = "888741852",
                        email = "robert.anderson@example.com",
                        prescriptionNumber = "RX010",
                        lastVisitDate = LocalDate.of(2023, 2, 18),
                        comments = "Glasses for reading",
                    ),
                    Client(
                        id = "11",
                        firstName = "Laura",
                        lastName = "Thomas",
                        phoneNumber = "999159753",
                        email = "laura.thomas@example.com",
                        prescriptionNumber = "RX011",
                        lastVisitDate = LocalDate.of(2023, 1, 9),
                        comments = null,
                    ),
                    Client(
                        id = "12",
                        firstName = "James",
                        lastName = "White",
                        phoneNumber = "1011121314",
                        email = "james.white@example.com",
                        prescriptionNumber = "RX012",
                        lastVisitDate = LocalDate.of(2023, 12, 22),
                        comments = "Scheduled for eye exam",
                    ),
                ),
            )
        }
    }
}
