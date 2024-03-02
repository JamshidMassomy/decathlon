import { ACTION } from '../../util/constants';
import initialState from '../initialstate';

export default function sportReducer(state = initialState, action: any) {
  switch (action.type) {
    case ACTION.FETCH_SPORT:
      return {
        ...state,
        data: action.payload,
      };

    case ACTION.FETCH_FAIL_SPORT:
      return {
        ...state,
        data: [],
        error: action.payload,
      };
    default:
      return state;
  }
}
