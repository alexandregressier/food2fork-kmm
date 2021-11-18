import SwiftUI
import shared

struct RecipeListView: View {
    
    @ObservedObject var viewModel = RecipeListViewModel()

    var body: some View {
        VStack {
            Text("\(viewModel.state.page)")
            Button(action: { viewModel.handleNextPage() }) {
                Text("Increment")
            }
        }
    }
}
