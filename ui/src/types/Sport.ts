enum Sport {
  LONG_JUMP,
  HIGH_JUMP,
  SHOT_PUT,
  POLE_VAULT,
  ONE_HUNDRED_METER,
  FOUR_HUNDRED_METER,
  JAVELIN_THROW,
  DISCUS_THROW,
  ONE_HUNDRED_TEN_METERS_HURDLES,
}

export function isValidSport(value: string) {
  return Object.values(Sport).includes(value);
}
