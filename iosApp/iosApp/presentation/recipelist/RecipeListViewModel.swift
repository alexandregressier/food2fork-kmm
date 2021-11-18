import SwiftUI
import shared

class RecipeListViewModel: ObservableObject {
    
    @Published var state: RecipeListState = RecipeListState()
    
    func handleNextPage() {
        state = state.doCopy(
            isLoading: state.isLoading,
            query: state.query,
            selectedFoodCategory: state.selectedFoodCategory,
            page: state.page + 1,
            recipes: state.recipes,
            messages: state.messages
        )
    }
}
