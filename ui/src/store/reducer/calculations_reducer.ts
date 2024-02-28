import { ACTION } from '../../util/constants';
import initialState from '../initialstate';

export default function calculationsReducer(state = initialState, action: any) {
  switch (action.type) {
    case ACTION.FETCH_CALCULATIONS:
      return {
        ...state,
        events: action.payload,
      };

    case ACTION.FETCH_CALCULATIONS:
      return {
        ...state,
        events: [],
        error: action.payload,
        isDialogActive: false,
      };

    default:
      return state;
  }
}
